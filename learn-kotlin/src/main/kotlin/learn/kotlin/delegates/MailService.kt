package learn.kotlin.delegates

class MailService {

    operator fun invoke(init: Mail.() -> Unit) {
        val mail = Mail()
        mail.init()
        send(mail)
    }

    private fun send(mail: Mail) {
        println(mail.to)
        println(mail.subject)
        println(mail.body)
    }
}



class Mail {
    var to: String = ""
    var subject: String = ""
    var body: String = ""

}