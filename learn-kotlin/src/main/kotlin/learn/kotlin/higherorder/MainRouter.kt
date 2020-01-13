package learn.kotlin.higherorder

class Request(val query: String, val acceptType: String)
class StatusResult(var statusCode: Int, var statusText: String)
class Response(val statusResult: StatusResult) {
    operator fun invoke(statusResult: StatusResult.() -> Unit) {
        val s = StatusResult(0,"")
        s.statusResult()
       printme(s)
    }

    fun printme(statusResult: StatusResult) {
        println("aaaa")
        println(statusResult.statusCode)
    }
}
class RouteHandler(val request: Request, val response: Response)

fun get(path: String, func: RouteHandler.() -> Unit) = func

fun main() {

    get("/index") {
        if(request.acceptType == "") {
            response {
                statusCode = 405
                statusText  = "Invalid media type"
            }
        }
    }

    val service = MessageService()
    service {
        body = "Hello Thando"
        email = "thando@supajam.com"
    }
}

class MessageService {
    operator fun invoke(init: Message.() -> Unit) {
        val message = Message()
        message.init()
        sendMessage(message)
    }

    fun sendMessage(m: Message) {
        println(m.body)
        println(m.email)
    }
}

class Message() {
    var email: String = ""
    var body: String = ""
 }

