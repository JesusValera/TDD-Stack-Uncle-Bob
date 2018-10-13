import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StackTest {

    private var stack: Stack = BoundedStack.make(2)

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
        assertThrows<Stack.Overflow> { stack.push(1) }
    }

    @Test
    fun whenEmptyStackIsPopped_ShouldThrowUnderflow() {
        assertThrows<Stack.Underflow> { stack.pop() }
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
        assertThrows<Stack.IllegalCapacity> { BoundedStack.make(-1) }
    }

    @Test
    fun whenCreatingStackWithZeroCapacity_AnyPushShouldOverflow() {
        stack = BoundedStack.make(0)
        assertThrows<Stack.Overflow> { stack.push(1) }
    }

    @Test
    fun whenOneIsPushed_OneIsOnTop() {
        stack.push(1)
        assertEquals(1, stack.top())

        stack.push(5)
        assertEquals(5, stack.top())
    }

    @Test
    fun whenStackIsEmpty_TopThrowsEmpty() {
        assertThrows<Stack.Empty> { stack.top() }
    }

    @Test
    fun withZeroCapacityStack_TopThrowsEmpty() {
        stack = BoundedStack.make(0)
        assertThrows<Stack.Empty> { stack.top() }
    }

    @Test
    fun givenStackWithOneTwoPushed_FindOne() {
        stack.push(1)
        stack.push(2)
        assertEquals(1, stack.find(1))
        assertEquals(0, stack.find(2))
        assertEquals(-1, stack.find(3))
    }

}
