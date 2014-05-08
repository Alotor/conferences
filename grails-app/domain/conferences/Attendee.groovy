package conferences

class Attendee {
    transient attendeeService
    String name

    List<Talk> getTalks(){
        return attendeeService.listTalksForAtendee(this)
        //return TalkAttendee.findAllByAttendee(this).talk
    }

    static constraints = {
        name nullable:false, blank: false
    }
}
