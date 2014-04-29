package conferences

class ConferenceAdmin {
    static options = [
        list: [excludes: ['startDate', 'endDate']],
        show: [excludes: ['startDate', 'endDate']],
        edit: [excludes: ['startDate', 'endDate']],
    ]
}
