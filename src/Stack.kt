import java.lang.RuntimeException

class Stack private constructor(
        private val capacity: Int,
        private val elements: IntArray = IntArray(capacity)
) {

    private var size: Int = 0

    companion object {
        fun Make(capacity: Int): Stack {
            return Stack(capacity)
        }
    }

    fun isEmpty(): Boolean = (size == 0)

    fun getSize(): Int = size

    fun push(element: Int) {
        if (size == capacity)
            throw Overflow()
        elements[size++] = element
    }

    fun pop(): Int {
        if (isEmpty())
            throw Underflow()

        return elements[--size]
    }

    class Overflow : RuntimeException()

    class Underflow : RuntimeException()

}
