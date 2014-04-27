package conferences

import org.springframework.security.access.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class AttendeeController{

    def attendeeService
    def talkService

    def index(){
        def attendeeList=attendeeService.indexAttendee()
        if(attendeeList){
            flash.message="Listado de asistentes: "
            render view:"/attendee/list", model:['attendeeList': attendeeList]
        }else{
            flash.message="No hay ningún asistente dado de alta"
            render view: "/attendee/list", model:['attendeeList':attendeeList]
        }
    }

    def description(long id){
        def attendee=attendeeService.descriptionAttendee(id)

        render view: "/attendee/description", model:['attendee':attendee]
    }

    def showAdd(){
        def talkList=attendeeService.showAddAttendee()
        render view:"/attendee/add", model:['talkList':talkList]
    }

    def showUpdate(long id){
        def attendee=attendeeService.descriptionAttendee(id)
        def talklist=talkService.indexTalk()

        render view: "/attendee/update", model:['attendee':attendee, 'talklist':talklist]
    }

    def update(long id){
        def attendee=attendeeService.descriptionAttendee(id)
        def talkListIds = params.list('talkListIds')


        attendeeService.updateAttendeeTalks(attendee, talkListIds)


        redirect mapping:"descriptionAttendee", params:["id":id]

    }

    def add(){

        Talk talk = Talk.get(params.talksId)


        println "==============================="
        println "Nombre: ${params.name}"
        println "Talk: ${talk}"
        println "==============================="



        def attendee=Attendee.findByName(params.name)
        if(attendee){
            flash.message="Ya existe un asistente con ese nombre. Introduzca otro nombre"
            redirect mapping:"addAttendee"
        }else{
            if(params.name && talk){
                attendeeService.addAttendee(params.name, new Long(params.talksId))
                flash.message="Asistente introducido correctamente en la base de datos"
                redirect mapping:"listAttendees"
            }else{
                flash.error="Debe introducir el nombre del asistente"
                redirect mapping: "addAttendee"
            }
        }
    }

    def delete(long id){
        def attendee=attendeeService.deleteAttendee(id)
        redirect mapping: "listAttendees"
    }

}
