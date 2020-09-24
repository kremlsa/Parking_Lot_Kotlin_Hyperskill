import java.util.Scanner

// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    // implement your code here
    val num1 = input.nextInt()
    val num2 = input.nextInt()
    val num3 = input.nextInt()
    val num4 = input.nextInt()
    val box1 = Box(num1, num2, num4)
    val box2 = box1.copy(length = num3)
    println(box1)
    println(box2)
}