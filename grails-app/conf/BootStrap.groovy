import conferences.*

class BootStrap {
    def init = { servletContext ->
        log.debug "INICIANDO"

        def role = Role.findByAuthority("ROLE_ADMIN")
        if (!role) {
            role = new Role(authority: "ROLE_ADMIN").save()
        }

        def user = User.findByUsername("admin")
        if (!user) {
            user = new User(username:"admin", password:"admin").save()
        }

        def userRole = UserRole.findByUserAndRole(user, role)
        if (!userRole) {
            new UserRole(user:user, role:role).save()
        }

        10.times {
            new Attendee(name:"Attendee$it").save()
        }
    }

    def destroy = {
        log.debug "PARANDO"
    }
}
