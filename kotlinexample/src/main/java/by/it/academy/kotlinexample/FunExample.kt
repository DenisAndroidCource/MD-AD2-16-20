package by.it.academy.kotlinexample

import org.omg.CORBA.portable.Delegate
import kotlin.properties.Delegates

/**
 * 1) модификатор доступа
 * 2) оператор fun
 * 3) название метода
 * 4) перечисляете параметры
 * 5) указываеете возвращаемый тип
 */
class FunExample {

    private val field by lazy { }
    private var name: String by Delegates.observable("") {
        _, oldValue, newValue ->
    }

    private fun add(a: Int, b: Int): Int {
        return a + b
    }

    private fun addV2(a: Int, b: Int) = a + b

    private fun addV2(a: Int, b: Float) = a + b

    fun foo(a: Int, b: Int) {
        val valResult: Int = a + b
//        valResult = 2
        var varResult = a + b
        varResult = 2

        "asdasdasdas".isEmail()
        var notNullableVariable: Int = 15
//        notNullableVariable = null

        var nullableVariable: Int? = 15
        nullableVariable = null

        val res = nullableVariable?.toChar() ?: '5'

        nullableVariable?.inc()
    }

    class NestedClass {

    }

}