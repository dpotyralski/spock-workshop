package pl.dpotyralski.spockintroduction


import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class _19_StepwiseTest extends Specification {

    @Shared
    private String sharedMessage = ""

    def "should append `Hello`"() {
        when:
        sharedMessage += "Hello"
        then:
        sharedMessage == "Hello"
    }

    def "should append ` `"() {
        when:
        sharedMessage += " "
        then:
        sharedMessage == "Hello "
    }

    def "should append World"() {
        when:
        sharedMessage += "World"
        then:
        sharedMessage == "Hello World"
    }

}
