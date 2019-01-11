import kotlinx.coroutines.*

fun main(args: Array<String>) {
    println("lovely 1 thread= ${Thread.currentThread()}")

    GlobalScope.launch(Dispatchers.Default) {
        println("----Coroutine Started thread= ${Thread.currentThread()}")

        val number = async { secondLongOperation() }
        println("-----Awaiting for Second Job thread= ${Thread.currentThread()}")

        longOperation(number.await())
    }
    Thread.sleep(6000)

    println("lovely 2 thread= ${Thread.currentThread()}")
}

suspend fun longOperation(num: Int) {
    Thread.sleep(2000)

    println("-----lovely Long operations $num gotten! thread= ${Thread.currentThread()}")
}

suspend fun secondLongOperation(): Int {
    Thread.sleep(2000)
    println("-----Second long operation done thread= ${Thread.currentThread()}")
    return 20;
}