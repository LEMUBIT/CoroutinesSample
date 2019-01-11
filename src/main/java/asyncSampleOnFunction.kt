import kotlinx.coroutines.*

fun main(args: Array<String>) {
    GlobalScope.launch {
        println("waiting")
        val text = login()
        val tagText = tag()

        //would not get printed because 2000 millis would have reached
        //coroutine was suspended at login() and tag()
        //use async{} await for faster asyncronous operation
        println("Got it = $text")
        println("Got it = $tagText")
    }
    Thread.sleep(2000)

}

suspend fun login(): String {

    Thread.sleep(1000)
    return "love"
}

suspend fun tag(): String {

    Thread.sleep(1000)
    return "tag"
}


