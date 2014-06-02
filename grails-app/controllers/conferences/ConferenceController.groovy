package conferences

import org.springframework.security.access.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class ConferenceController {
    def conferenceService
    def grailsResourceLocator

    def index() {
        String resource = "grails-admin/libs/lodash.js"
        def tmp = grailsResourceLocator.findResourceForURI(resource).file.path
        println tmp.substring(tmp.indexOf("work/")+4).replaceAll("web-app/","")
        println tmp

        render view:"/conference/home", model:[]
    }

    def list() {
        def conferenceList=conferenceService.listConference()
        if(conferenceList){
            flash.message="Listado de conferencias:"
            render view:"/conference/list", model:['conferenceList':conferenceList]
        }else{
            flash.message="Por el momento, no hay creada ninguna conferencia"
            render view:"/conference/list", model:['conferenceList':conferenceList]
        }
    }

    def description(long id){
        def conference = conferenceService.descriptionConference(id)
        render view:"/conference/description", model:['conference':conference]
    }

    def showAdd(){
        render view:"/conference/add", model:[]
    }

    def add(){
        //def conference = Conference.findByName('conferenciaA')
        def conference = Conference.findByName(params.name)
        if(conference){
            flash.message="Ya existe una conferencia creada con ese nombre. Introduzca otra conferencia"
            redirect mapping:"addConference"
        }else{
            if(params.name && params.startDate && params.endDate){
                conferenceService.addConference(params.name,params.startDate, params.endDate)
                flash.message="Conferencia creada correctamente"
                redirect mapping:"listConferences"
            }else{
                flash.error="No se ha podido añadir la conferencia. Debe rellenar todos los campos"
                redirect mapping:"addConference"
            }
        }
    }

    def delete(long id){
        conferenceService.deleteConference(id)
        redirect mapping:"listConferences"
    }

    def showUpdate(long id){
        def conference=conferenceService.showUpdateConference(id)
        render view:"/conference/update", model:['conference':conference]
    }

    def update(long id){
        def conference = Conference.get(id)
        conference = conferenceService.updateConference(conference, params.name,params.startDate, params.endDate)
        redirect mapping:"descriptionConference", params:["id":conference.id]
    }
}
