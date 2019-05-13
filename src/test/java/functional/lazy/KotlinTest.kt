package functional.lazy

import arrow.syntax.function.memoize
import io.kotlintest.runner.junit4.KotlinTestRunner
import io.kotlintest.shouldBe
import org.junit.runner.RunWith

import arrow.test.UnitSpec

@RunWith(KotlinTestRunner::class)
class FunctionSyntaxTest : UnitSpec() {

    init {
        "memoize" {
            var counterA = 0
            var counterB = 0

            val a = { _: Int -> counterA++ }
            val b = { _: Int -> counterB++ }.memoize()

            repeat(5) { a(1) }
            repeat(5) { b(1) }

            counterA shouldBe 5
            counterB shouldBe 1 // calling several times a memoized function with the same parameter is computed just once
        }

    }
}