package learn.kotlin.delegates

fun main() {
    val send = MailService()
    send {
        to = "thando.mafela@hotmail.com"
        subject = "Aids campaign"
        body = "Hello world"
    }
}