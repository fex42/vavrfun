package functional

import arrow.syntax.function.memoize

fun loadContents(): String {
    val id = System.nanoTime() % 1000
    println("### loading contents from file ($id) ###")
    Thread.sleep(250)

    return "Contents #$id"
}


val kotlinLoadContents = { loadContents() }

val kotlinMemoized = { loadContents() }.memoize()

fun main() {
    println("Kotlin without memoization:")
    println("call #1: ${kotlinLoadContents()}")
    println("call #2: ${kotlinLoadContents()}")
    println("call #3: ${kotlinLoadContents()}")

    println("\nKotlin memoized:")
    println("call #1: ${kotlinMemoized()}")
    println("call #2: ${kotlinMemoized()}")
    println("call #3: ${kotlinMemoized()}")
}