package pl.dpotyralski.spockintroduction

import spock.lang.*

@Title("Bonus test to tell you more about about other annotations")
@Narrative("""
Aka
more description
can be added here if needed
""")
@Issue("You can include here your issue")
@See("Check this page to know more!")
class _23_BonusTest extends Specification {

    @FailsWith(RuntimeException)
    def "should fail with Runtime exception"() {
        expect:
        throw new RuntimeException()
    }

    def "should know more about hello old version"() {
        given:
        String hello = "Hello"

        when:
        hello = "I'm not longer the one"

        then:
        hello == "I'm not longer the one"
        old(hello) == "Hello"
    }

}
