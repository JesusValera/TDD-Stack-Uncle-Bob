import java.lang.RuntimeException

class Stack private constructor(val capacity: Int) {

    private var size: Int = 0

    companion object {
        fun Make(capacity: Int): Stack {
            return Stack(capacity)
        }
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun getSize(): Int {
        return size
    }

    fun push(element: Int) {
        if (size == capacity)
            throw Overflow()
        size++
    }

    fun pop(): Int {
        if (isEmpty())
            throw Underflow()
        return --size
    }

    class Overflow : RuntimeException()

    class Underflow : RuntimeException()

}
