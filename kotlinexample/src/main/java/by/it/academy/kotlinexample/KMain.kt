package by.it.academy.kotlinexample

fun String.isEmail(): Boolean {
    return this.length > 10
}

class Obj {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            FunExample().foo(1, 2)
            User(
                serviceValue = 1,
                address = "Address"
            )
        }
    }
}
