class Stack {

    private var size: Int = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun getSize(): Int {
        return size
    }

    fun push(element: Int) {
        size++
    }

}
