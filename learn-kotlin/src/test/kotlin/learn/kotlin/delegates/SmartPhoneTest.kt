package learn.kotlin.delegates

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.properties.Delegates

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SmartPhoneTest {

    private val smartPhone = SmartPhone()
    private var shouldNotNotBeNull: String by Delegates.notNull<String>()
    private var watched: Int by Delegates.observable(1) { property, oldValue, newValue ->
        println("${property.name} changed from $oldValue to $newValue" )
    }

    var checked: Int by Delegates.vetoable(0) { prop, old, new ->
        println("Trying to change ${prop.name} from $old to $new")
        new >= 0
    }

    @Test
    fun `Dialing delegates to internal phone`() {
        assertEquals("Dialing 555-1234", smartPhone.dial("555-1234"))
    }

    @Test
    fun `Taking pictures delegates to internal camera`() {
        assertEquals("Taking picture...",
                smartPhone.takePicture())
    }

    @Test
    fun `uninitialized value throws exception`() {
        assertThrows(IllegalStateException::class.java) { shouldNotNotBeNull}
    }

    @Test
    fun `initialize value to retrieve it`() {
        shouldNotNotBeNull = "Hello, World"
        assertDoesNotThrow {  shouldNotNotBeNull }
        assertEquals("Hello, World", shouldNotNotBeNull)
    }

    @Test
    fun `watched variable prints old and new values`() {
        assertEquals(1, watched)
        watched *= 2
        assertEquals(2, watched)
        watched *= 2
        assertEquals(4, watched)
    }

    @Test
    fun `veto values less than zero`() {
        assertAll(
                { assertEquals(0, checked) },
                { checked = 42; assertEquals(42, checked) },
                { checked = -1; assertEquals(42, checked) },
                { checked = 17; assertEquals(17, checked) }
        )
    }

    @Test
    fun `use map delegate for project`() {
        val project = Project(
                mutableMapOf(
                        "name" to "Learn Kotlin",
                        "priority" to 5,
                        "completed" to true)
        )

        assertAll(
                { assertEquals("Learn Kotlin", project.name) },
                { assertEquals(5, project.priority) },
                { assertTrue(project.completed) }
        )
    }


}