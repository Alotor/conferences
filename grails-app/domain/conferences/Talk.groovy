package conferences

class Talk {

    String name
    String talkDate
    String talkTime
    static belongsTo = [speaker:Speaker]

    Room room


    static constraints = {
        room nullable:true
        speaker nullable:true
        talkDate nullable:true
        talkTime nullable:true
    }

    String toString(){
        return name
    }
}
