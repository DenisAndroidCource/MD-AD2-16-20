package by.it.academy.kotlinexample

open class User constructor(
    serviceValue: Int,
    private val name: String = "Denis",
    private val address: String
) {
    private lateinit var service: String

    constructor(name: String) : this(1, name, "")

    fun doJob() {
        foo(1, 2, "A")
        foo(b = 2, a = 1)
    }

    fun foo(a: Int, b: Int, c: String = "Value") { // c = "Value"
        service = ""
        service.length
    }
}

interface Role {
    fun isSuperUser()
}

abstract class BaseController {
    abstract fun checkRole(role: Role)
}

class RoleController: BaseController() {

    fun control(){
        checkRole(object : Role {
            override fun isSuperUser() {

            }
        })
    }

    override fun checkRole(role: Role) {
        role.isSuperUser()
    }
}

class Admin(name: String) : User(name), Role {
    override fun isSuperUser() {

    }
}