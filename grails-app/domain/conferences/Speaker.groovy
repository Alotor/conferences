package conferences

class Speaker {

    static hasMany=[talks:Talk]
    String name
    String birthDate
    SpeakerGender gender = SpeakerGender.FEMALE

    static constraints = {
        gender nullable:true
    }

    String toString(){
        return name
    }
}

enum SpeakerGender {
    MALE, FEMALE
}
