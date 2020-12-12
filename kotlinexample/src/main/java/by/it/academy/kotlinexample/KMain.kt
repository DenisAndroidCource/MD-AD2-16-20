package by.it.academy.kotlinexample

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
