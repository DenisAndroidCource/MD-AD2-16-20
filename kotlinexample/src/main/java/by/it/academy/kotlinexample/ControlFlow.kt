package by.it.academy.kotlinexample

// if-else
// when
fun control(number: Int) {
    val result: String = if (number % 2 == 0) {
        (number * 50).toString()
    } else {
        "НеЧет"
    }

    if (number > 0) {
        System.out.println("Gr")
    } else {
        System.out.println("Lw")
    }
}

fun controlWhen(message: String) {
    when {
        message == "Hello" -> System.out.println("asdasd")
        message.length > 100 -> System.out.println("asdasd")
        else -> System.out.println("No!")
    }

    val result = when (message) {
        "HELLO" -> if (message.length > 10) 1 else 100
        "HI" -> 2
        else -> 0
    }.toDouble()
}

fun loop() {
    val array: Array<Int> = arrayOf(1, 5, 50, 80)

    for (item in array) {
        System.out.println(item)
    }

    for (index in array.indices) {
        System.out.println(array[index])
    }

    for (index in 0 until array.size) {
        System.out.println(array[index])
    }

    for (i in 10 downTo 0) {

    }

    val a = A()
    a.doJob()
}

fun stringsExample() {
    val b = 1
   val a = "A = $b as a result"
   val c = """asadasd
       
       A = $b as a result"
       asdasd
       asd
       sad
       
       
       asd
   """.trimIndent()

}