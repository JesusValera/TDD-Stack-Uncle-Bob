import java.lang.RuntimeException

interface Stack {

    fun isEmpty(): Boolean

    fun getSize(): Int

    fun push(element: Int)

    fun pop(): Int

    fun top(): Int

    class IllegalCapacity : RuntimeException()

    class Empty : RuntimeException()

}