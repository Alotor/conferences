package conferences

import org.springframework.security.access.annotation.Secured

@Secured(['IS_AUTHENTICATED_ANONYMOUSLY'])
class RoomController{

    def roomService
    def talkService

    def index(){
        def roomList=roomService.indexRoom()
        if(roomList){
            flash.message="List of rooms:"
            render view:"/room/list", model:['roomList':roomList]
        }else{
            flash.message="There is no rooms in the database"
            render view:"/room/list", model:['roomList':roomList] //Hay que poner el modelo pq si no me aparece en todas las paginas
        }
    }

    def description(long id){
        def room=roomService.descriptionRoom(id)
        render view:"/room/description", model:['room':room]
    }

    def showAdd(){
        def talkList = roomService.showAddRoom()
        render view:"/room/add", model:['talkList':talkList]
    }

    def add(){
        Talk talk = Talk.get(params.talksId)

        def room=Room.findByName(params.name)
        if (room){
            flash.message="Ya existe dicha sala. Introduzca otro nombre"
            redirect mapping:"addRoom"
        }else{
            if(params.name && talk){
                roomService.addRoom(params.name,talk)
                flash.message="Sala creada correctamente"
                redirect mapping:"listRooms"
            }else{
                flash.error="La nueva sala no ha sido creada. Debe introducir un nombre en el formulario"
                redirect mapping:"addRoom"
            }
        }
    }

    def delete(long id){
        def room=roomService.deleteRoom(id)
        redirect mapping: "listRooms"
    }
}
