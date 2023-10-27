package pl.dpotyralski.spockintroduction


import spock.lang.Specification

class _3_SharedTest extends Specification {

//    @Shared
    private SharedObject sharedOne = new SharedObject()

    def "should get Buzz"() {
        expect:
        sharedOne.resolve(1) == "1"
    }

    def "should get Fizz"() {
        expect:
        sharedOne.resolve(2) == "2"
    }

    def "should get FizzBuzz"() {
        expect:
        sharedOne.resolve(3) == "3"
    }

}

class SharedObject {
    SharedObject() {
        println "Hello from constructor"
    }

    def resolve(int number) {
        return number.toString()
    }
}