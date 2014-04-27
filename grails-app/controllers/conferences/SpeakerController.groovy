package conferences

import org.springframework.security.access.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class SpeakerController {

    def speakerService

    def index() {
        def speakerList = speakerService.indexSpeaker()
        if(speakerList){
            flash.message="Listado de ponentes:"
            render view:"/speaker/list", model:['speakerList':speakerList]
        }else{
            flash.message="En la base de datos no hay ponentes"
            render view:"/speaker/list", model:['speakerList':speakerList]
        }
    }

    def description(long id){
        def speaker=speakerService.descriptionSpeaker(id)
        render view:"/speaker/description", model:['speaker':speaker]
    }

    def showAdd(){
        render view:"/speaker/add", model:[]
    }

    def add(){
        def speaker=Speaker.findByName(params.name)
        if (speaker){
            flash.message="Ya existe un ponente con ese nombre. Introduzca otro nombre"
            redirect mapping:"addSpeaker"
        }else{
            if(params.name && params.birthDate){
                speakerService.addSpeaker(params.name,params.birthDate)
                flash.message="Ponente creado correctamente"
                redirect mapping:"listSpeakers"
            }else{
                flash.error="El nuevo ponente no se ha creado. Debe completar todos los campos del formulario"
                redirect mapping:"addSpeaker"
            }
        }
    }

    def delete(long id){
        speakerService.deleteSpeaker(id)
        redirect mapping:"listSpeakers"
    }

    def showUpdate(long id){
        def speaker = Speaker.get(id)
        render view:"/speaker/update", model:['speaker':speaker]
    }

    def update(long id){
        def speaker = Speaker.get(id)
        speakerService.updateSpeaker(speaker,params.name,params.birthDate)
        redirect mapping:"descriptionSpeaker", params:["id":speaker.id]
    }

}
