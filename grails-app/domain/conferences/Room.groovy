package conferences

class Room {
    String name
    Integer roomNumber
    File photo
    Boolean board = false
    static hasMany=[talk:Talk]

    static constraints = {
        photo nullable:true
        roomNumber nullable:true
        name validator: {val,obj->
            if (val.startsWith("A")) {
                return false
            }
            return true
        }
    }

    String toString(){
        return name
    }
}
