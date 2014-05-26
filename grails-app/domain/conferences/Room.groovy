package conferences

class Room {
    String name
    File photo
    Boolean board = false
    static hasMany=[talk:Talk]

    static constraints = {
        photo nullable:true
    }

    String toString(){
        return name
    }
}
