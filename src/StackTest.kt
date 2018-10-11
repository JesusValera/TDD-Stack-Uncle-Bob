import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class StackTest {

    @Test
    fun createStack() {
        val stack = Stack()
        assertTrue(stack.isEmpty())
    }
}
