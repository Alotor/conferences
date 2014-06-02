package conferences

class ConferenceAdmin {
    static options = {
        list excludes: ['startDate', 'endDate']
        edit excludes: ['startDate', 'endDate']
        widget "name", "PasswordInputWidget"
        widget "address", "sample.MapWidget", width: 500, height: 100
    }
}
