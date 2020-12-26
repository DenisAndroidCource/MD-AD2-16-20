package by.it.academy.kotlinexample

fun collectionFoo() {
    val mutableList = mutableListOf(1, 2, 4)
    mutableList.add(1)
    mutableList.add(1)
    mutableList.add(1)
    mutableList.removeAt(0)
    val immutableList = listOf(1, 2, 4)
//    immutableList.add()
//    immutableList.remove()

    val filteredList = mutableListOf(1, 2, 3, 4, 5, 6)
        .filter { value -> value % 2 != 0 }
        .map { value -> value.toString() }
//        .find { value -> value.length > 5 }
    filteredList.forEach { value -> System.out.println(value) }
    listOf(1, 2, 3)
    setOf(1, 2, 3)
    arrayOf(1, 2, 3)
    mutableMapOf(1 to 3, 2 to 1, 3 to 5)
//        .forEach { key, value -> }
}