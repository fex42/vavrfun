package functional.immutability

data class KotlinRGB(val red: Int, val green: Int, val blue: Int)

fun main() {
    val black = KotlinRGB(red=0,green=0,blue=0)

    val green = black.copy(green=255)

    println("black = $black")
    println("green = $green")
}