import conferences.*

class BootStrap {
    def init = { servletContext ->
        log.debug "INICIANDO"

        def role = new Role(authority: "ROLE_ADMIN").save()
        def user = new User(username:"admin", password:"admin").save()
        new UserRole(user:user, role:role).save()
    }

    def destroy = {
        log.debug "PARANDO"
    }
}
