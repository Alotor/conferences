package conferences

class Talk {

    String name
    String talkDate
    String talkTime
    static belongsTo = [speaker:Speaker]
    Room room

    static constraints = {
        room nullable:true
    }

    String toString(){
        return name
    }
}
