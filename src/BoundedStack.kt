import java.lang.RuntimeException

class BoundedStack private constructor(private val capacity: Int) : Stack {

    private val elements: IntArray = IntArray(capacity)
    private var size: Int = 0

    companion object {
        fun make(capacity: Int): Stack {
            if (capacity < 0)
                throw Stack.IllegalCapacity()
            if (capacity == 0)
                return ZeroCapacityStack()

            return BoundedStack(capacity)
        }
    }

    override fun isEmpty(): Boolean = (size == 0)

    override fun getSize(): Int = size

    override fun push(element: Int) {
        if (size == capacity)
            throw Overflow()
        elements[size++] = element
    }

    override fun pop(): Int {
        if (isEmpty())
            throw Underflow()

        return elements[--size]
    }

    override fun top(): Int {
        if (isEmpty())
            throw Stack.Empty()

        return elements[size - 1]
    }

    class Overflow : RuntimeException()

    class Underflow : RuntimeException()

    private class ZeroCapacityStack : Stack {

        override fun isEmpty(): Boolean {
            return true
        }

        override fun getSize(): Int {
            return 0
        }

        override fun push(element: Int) {
            throw Overflow()
        }

        override fun pop(): Int {
            throw Underflow()
        }

        override fun top(): Int {
            throw Stack.Empty()
        }
    }

}
