class UrlMappings {

    static mappings = {
        name "index": "/" {controller="conference"; action="index"}

        name "login": "/login/auth" {controller="login"; action="auth"}
        name "loginDenied": "/login/denied" {controller="login"; action="denied"}

        name "listConferences": "/listConferences" {controller="conference"; action="list"}
        name "descriptionConference": "/description/$id" {controller="conference"; action="description"}
        name "addConference": "/add" {controller="conference"; action=[GET:"showAdd", POST:"add"]}
        name "deleteConference": "/delete/$id" {controller="conference"; action="delete"}
        name "updateConference": "/update" {controller="conference"; action=[GET:"showUpdate", POST:"update"]}

        name "listSpeakers": "/listSpeakers" {controller="speaker";action="index"}
        name "descriptionSpeaker": "/descriptionSpeaker/$id" {controller="speaker"; action="description"}
        name "addSpeaker": "/addSpeaker" {controller="speaker"; action=[GET:"showAdd", POST:"add"]}
        name "deleteSpeaker": "/deleteSpeaker/$id" {controller="speaker"; action="delete"}
        name "updateSpeaker": "/updateSpeaker" {controller="speaker"; action=[GET:"showUpdate", POST:"update"]}

        name "listTalks": "/listTalks" {controller="talk";action="index"}
        name "descriptionTalk": "/descriptionTalk/$id" {controller="talk"; action="description"}
        name "addTalk": "/addTalk" {controller="talk"; action=[GET:"showAdd", POST:"add"]}
        name "deleteTalk": "/deleteTalk/$id" {controller="talk"; action="delete"}
        name "updateTalk": "/updateTalk" {controller="talk"; action=[GET:"showUpdate", POST:"update"]}

        name "listAttendees": "/listAttendees" {controller="attendee"; action="index"}
        name "descriptionAttendee": "/descriptionAttendee/$id" {controller="attendee"; action="description"}
        name "addAttendee": "/addAttendee" {controller="attendee"; action=[GET:"showAdd", POST:"add"]}
        name "deleteAttendee": "/deleteAttendee/$id" {controller="attendee"; action="delete"}
        name "updateAttendee": "/updateAttendee" {controller="attendee"; action=[GET:"showUpdate", POST:"update"]}

        name "listRooms": "/listRooms" {controller="room"; action="index"}
        name "descriptionRoom": "/descriptionRoom/$id" {controller="room"; action="description"}
        name "addRoom": "/addRoom" {controller="room"; action=[GET:"showAdd", POST:"add"]}
        name "deleteRoom": "/deleteRoom/$id" {controller="room"; action="delete"}


        "500"(view:'/error')
    }
}
