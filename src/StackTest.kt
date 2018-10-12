import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StackTest {

    private val stack: Stack = Stack.Make(2)

    @Test
    fun newlyCreateStack_ShouldBeEmpty() {
        assertTrue(stack.isEmpty())
        assertEquals(0, stack.getSize())
    }

    @Test
    fun afterOnePush_StackSizeShouldBeOne() {
        stack.push(1)
        assertEquals(1, stack.getSize())
        assertFalse(stack.isEmpty())
    }

    @Test
    fun afterOnePushAndOnePop_ShouldBeEmpty() {
        stack.push(1)
        stack.pop()
        assertTrue(stack.isEmpty())
    }

    @Test
    fun whenPushedPastLimit_StackOverflows() {
        stack.push(1)
        stack.push(1)
        assertThrows<Stack.Overflow>("Should throw an exception") {
            stack.push(1)
        }
    }

}
