package conferences

class RoomController{

    def roomService

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
		render view:"/room/add", model:[]
    }
    
    def add(){
		def room=Room.findByName(params.name)
		if (room){
			flash.message="Ya existe dicha sala. Introduzca otro nombre"
			redirect mapping:"addRoom" 
		}else{
			if(params.name){
				roomService.addRoom(params.name)
				flash.message="Sala creada correctamente"
				redirect mapping:"listRooms" 
			}else{
				flash.error="La nueva sala no ha sido creada. Debe introducir un nombre en el formulario"
				redirect mapping:"addRoom"
			}
		}
    }
}
