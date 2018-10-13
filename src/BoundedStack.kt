import java.lang.RuntimeException

class BoundedStack private constructor(private val capacity: Int) : Stack {

    private val elements: IntArray = IntArray(capacity)
    private var size: Int = 0

    companion object {
        fun Make(capacity: Int): Stack {
            if (capacity < 0)
                throw IllegalCapacity()
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

    class Overflow : RuntimeException()

    class Underflow : RuntimeException()

    class IllegalCapacity : RuntimeException()

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
    }

}
