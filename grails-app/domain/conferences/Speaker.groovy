package conferences

class Speaker {

    static hasMany=[talks:Talk]
    String name
    String birthDate

    static constraints = {
    }

    String toString(){
        return name
    }
}
