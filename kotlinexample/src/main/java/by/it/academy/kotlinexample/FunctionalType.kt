package by.it.academy.kotlinexample

import java.lang.Exception

interface FunctionType<T> {
    fun invoke(data: T)
}

//val function: (String) -> Int
class PasswordController {

    fun validatePassword(
        password: String,
        validation: (String) -> Boolean
    ) = validation(password)

    fun foo() {
        validatePassword("123") { password -> password.length > 5 }
        validatePassword("123") { password -> password.endsWith("!") }
        validatePassword("123") { password ->
            if (password.length > 10) {
                password.startsWith("@!")
            } else {
                password.endsWith("@!")
            }
        }
        validatePassword("123", FunctionTypeClass())

        try {
            A().externalJob()
        } catch (e: Exception) {

        }
    }
}

class FunctionTypeClass : (String) -> Boolean {
    override fun invoke(p1: String): Boolean {
        return true
    }
}