package conferences

class Conference {

    String name
    String startDate
    String endDate
    String address

    static hasMany=[talks:Talk, speakers:Speaker]

    static constraints = {
        address nullable:true, blank: true
    }
}
