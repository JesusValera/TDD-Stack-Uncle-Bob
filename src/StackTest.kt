import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StackTest {

    private var stack: Stack = BoundedStack.Make(2)

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
        assertThrows<BoundedStack.Overflow> { stack.push(1) }
    }

    @Test
    fun whenEmptyStackIsPopped_ShouldThrowUnderflow() {
        assertThrows<BoundedStack.Underflow> { stack.pop() }
    }

    @Test
    fun whenOneAndTwoArePushed_TwoAndOneArePopped() {
        stack.push(1)
        stack.push(2)
        assertEquals(2, stack.pop())
        assertEquals(1, stack.pop())
    }

    @Test
    fun whenCreatingSackWithNegativeSize_ShouldThrowIllegalCapacity() {
        assertThrows<BoundedStack.IllegalCapacity> { BoundedStack.Make(-1) }
    }

    @Test
    fun whenCreatingStackWithZeroCapacity_AnyPushShouldOverflow() {
        stack = BoundedStack.Make(0)
        assertThrows<BoundedStack.Overflow> { stack.push(1) }
    }
}
