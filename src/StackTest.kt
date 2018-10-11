import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StackTest {

    @Test
    fun newlyCreateStack_ShouldBeEmpty() {
        val stack = Stack()
        assertTrue(stack.isEmpty())
        assertEquals(0, stack.getSize())
    }

    @Test
    fun afterOnePush_StackSizeShouldBeOne() {
        val stack = Stack()
        stack.push(1)
        assertEquals(1, stack.getSize())
        assertFalse(stack.isEmpty())
    }
}
