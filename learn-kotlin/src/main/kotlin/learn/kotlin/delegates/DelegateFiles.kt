package learn.kotlin.delegates

interface Dialable {
    fun dial(number: String): String
}

class Phone : Dialable {

    override fun dial(number: String) = "Dialing $number"
}

interface Snappable {
    fun takePicture(): String
}

class Camera : Snappable {
    override fun takePicture() =  "Taking picture..."
}

class SmartPhone(private val phone: Dialable = Phone(), private val camera: Snappable = Camera()) : Dialable by phone, Snappable by camera

data class Project(val map: MutableMap<String, Any?>) {
    val name: String by map
    val priority: Int by map
    var completed: Boolean by map
}

