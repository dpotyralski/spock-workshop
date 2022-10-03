package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.fizzbuzz.FizzBuzzResolver
import spock.lang.Shared
import spock.lang.Specification

class _3_SharedTest extends Specification {

    @Shared
    private FizzBuzzResolver resolver = new FizzBuzzResolver()

    def "should get Buzz"() {
        expect:
        resolver.resolve(5) == "Buzz"
    }

    def "should get Fizz"() {
        expect:
        resolver.resolve(3) == "Fizz"
    }

    def "should get FizzBuzz"() {
        expect:
        resolver.resolve(15) == "FizzBuzz"
    }

    def "should get string version of passed result"() {
        expect:
        resolver.resolve(2) == "2"
    }


}