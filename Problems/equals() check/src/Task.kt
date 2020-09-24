import java.util.Scanner

data class Client(val name: String, val age: Int, val balance: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client

        if (name != other.name) return false
        if (age != other.age) return false
        return true
    }
}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    //implement your code here
    val num1 = input.next()
    val num2 = input.nextInt()
    val num3 = input.nextInt()
    val num4 = input.next()
    val num5 = input.nextInt()
    val num6 = input.nextInt()
    val c1 = Client(num1, num2, num3)
    val c2 = Client(num4, num5, num6)
    println(c1 == c2)
}