package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.rental.Person
import spock.lang.Specification

class _1_SpockIntro extends Specification {

    def "should run your first Spock test"() {
        expect:
        new Person("Spock").getName() == "Spock"
    }

}