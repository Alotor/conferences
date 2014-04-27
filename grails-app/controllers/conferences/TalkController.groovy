package conferences

import org.springframework.security.access.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class TalkController {

    def talkService

    def index() {
        def talklist=talkService.indexTalk()
        if(talklist){
            flash.message="Listado de charlas:"
            render view:"/talk/list", model:['talklist':talklist]
        }else{
            flash.message="En la base de datos no hay charlas"
            render view:"/talk/list", model:['talklist':talklist]
        }
    }

    def description(long id){
        def talk=talkService.descriptionTalk(id)
        render view:"/talk/description", model:['talk':talk]
    }

    def showAdd(){ //Es el controlador el que tiene q coger la lista o el servicio??????????
        def speakerList = talkService.showAddTalk()
        render view:"/talk/add", model:['speakerList':speakerList]
    }

    def add(){
        Speaker speaker = Speaker.get(params.speakerId)
        def talk=Talk.findByName(params.name)
        if(talk){
            flash.message="Ya existe una charla con ese nombre. Introduzca otro título"
            redirect mapping:"addTalk"
        }else{
            if(params.name && params.talkDate && params.talkTime && speaker){
                talkService.addTalk(params.name,params.talkDate,params.talkTime, speaker)
                flash.message="Charla creada correctamente"
                redirect mapping:"listTalks"
            }else{
                flash.error="La charla no se ha creado. Debe completar todos los campos del formulario"
                redirect mapping:"addTalk"
            }
        }
    }

    def delete(long id){
        def talk=talkService.deleteTalk(id)
        redirect mapping:"listTalks"
    }

    def showUpdate(long id){
        def talk=Talk.get(id)
        def speakerList = Speaker.list()
        render view:"/talk/update", model:['talk':talk, 'speakerList':speakerList]
    }

    /**
    def update(long id){
        def talk=Talk.get(id)
        Speaker speaker = Speaker.get(params.speakerId)
        talk.name=params.name
        talk.talkDate=params.talkDate
        talk.talkTime=params.talkTime
        talk.speaker=speaker
        talk.save()
        redirect mapping:"descriptionTalk", params:["id":talk.id]
    }
    */

    def update(long id){
        def talk=Talk.get(id)
        Speaker speaker = Speaker.get(params.speakerId)
        talkService.updateTalk(talk,params.name,params.talkDate,params.talkTime,speaker)
        redirect mapping:"descriptionTalk", params:["id":talk.id]
    }

}
