package by.it.academy.kotlinexample

data class Data(
    val data:String
)

sealed class Results {
    class Success(data: String) : Results()
    class Error(errCode: Int) : Results()
}

fun controlResult(result: Results){
    when(result) {
        is Results.Success -> runSuccess(result)
        is Results.Error -> runErorr(result)
    }
}

fun runSuccess(result: Results.Success){

}

fun runErorr(result: Results.Error){

}

enum class Result {
    SUCCESS, ERROR
}