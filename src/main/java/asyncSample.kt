import kotlinx.coroutines.*

fun main(args: Array<String>) {
    println("lovely 1 thread= ${Thread.currentThread()}")

    GlobalScope.launch(Dispatchers.Default) {
        println("----Coroutine Started thread= ${Thread.currentThread()}")

        val number = async { longOperation() }
        println("-----Awaiting for Second Job thread= ${Thread.currentThread()}")

        secondLongOperation(number.await())
    }
    Thread.sleep(6000)

    println("lovely 2 thread= ${Thread.currentThread()}")
}

suspend fun secondLongOperation(num: Int) {
    println("-----Second Long operation started")
    delay(2000)
    println("-----Second Long operation done $num gotten! thread= ${Thread.currentThread()}")
}

suspend fun longOperation(): Int {
    println("-----Long operation started")
    delay(2000)
    println("-----long operation done thread= ${Thread.currentThread()}")
    return 20;
}