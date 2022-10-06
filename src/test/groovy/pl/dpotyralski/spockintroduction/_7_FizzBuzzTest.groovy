package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.fizzbuzz.FizzBuzzResolver
import spock.lang.Shared
import spock.lang.Specification

class _7_FizzBuzzTest extends Specification {

    @Shared
    private FizzBuzzResolver resolver = new FizzBuzzResolver()

    def "should resolve #value to #output"() {
        expect:
        resolver.resolve(value) == expectedResult

        where:
        value | expectedResult
        3     | "Fizz"
        5     | "Buzz"
        15    | "FizzBuzz"
        2     | "2"
        124   | "124"
        301   | ""

        output = expectedResult ?: 'empty'
    }


}