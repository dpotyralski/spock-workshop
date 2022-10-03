package pl.dpotyralski.spockintroduction


import spock.lang.Specification

class _5_ExceptionConditionTest extends Specification {

    private ExceptionProvider exceptionProvider = new ExceptionProvider()

    def "should catch the proper exception along with the message"() {
        when:
        exceptionProvider.operationUnsupported()
        then:
        UnsupportedOperationException e = thrown(UnsupportedOperationException)
        e.message == "Operation is not supported!"
    }

    def "should catch the general throwable"() {
        when:
        exceptionProvider.operationUnsupported()
        then:
        Throwable throwable = thrown()
        throwable instanceof UnsupportedOperationException
    }

    def "should not thrown illegal argument exception"() {
        when:
        exceptionProvider.operation()
        then:
        notThrown(UnsupportedOperationException)
    }

}