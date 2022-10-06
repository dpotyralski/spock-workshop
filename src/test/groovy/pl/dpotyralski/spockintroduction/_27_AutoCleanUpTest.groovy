package pl.dpotyralski.spockintroduction


import spock.lang.AutoCleanup
import spock.lang.Specification

class _27_AutoCleanUpTest extends Specification {

    @AutoCleanup(value = "operationUnsupported", quiet = true)
    ExceptionProvider exceptionProvider = new ExceptionProvider()

    def "Should use data from sql select"() {
        expect:
        exceptionProvider.operation()
    }

}
