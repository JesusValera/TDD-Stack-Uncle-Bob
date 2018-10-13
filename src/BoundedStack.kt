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
            throw Stack.Overflow()
        elements[size++] = element
    }

    override fun pop(): Int {
        if (isEmpty())
            throw Stack.Underflow()

        return elements[--size]
    }

    override fun top(): Int {
        if (isEmpty())
            throw Stack.Empty()

        return elements[size - 1]
    }

    override fun find(element: Int): Int {
        for (i in (size - 1) downTo 0) {
            if (element == elements[size - 1 - i])
                return i
        }

        return -1
    }

    private class ZeroCapacityStack : Stack {

        override fun isEmpty(): Boolean {
            return true
        }

        override fun getSize(): Int {
            return 0
        }

        override fun push(element: Int) {
            throw Stack.Overflow()
        }

        override fun pop(): Int {
            throw Stack.Underflow()
        }

        override fun top(): Int {
            throw Stack.Empty()
        }

        override fun find(element: Int): Int {
            return -1
        }
    }

}
