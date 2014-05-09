package conferences

class Room {
    String name
    static hasMany=[talk:Talk]

    String toString(){
        return name
    }
}
