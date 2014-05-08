package conferences

class ConferenceAdmin {
    static options = {
        list excludes: ['startDate', 'endDate']
        create excludes: ['startDate', 'endDate']
        edit excludes: ['startDate', 'endDate']
    }
}
