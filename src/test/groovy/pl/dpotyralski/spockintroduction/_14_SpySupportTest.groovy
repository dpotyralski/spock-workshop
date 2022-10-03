package pl.dpotyralski.spockintroduction


import pl.dpotyralski.spockintroduction.rental.Movie
import pl.dpotyralski.spockintroduction.rental.Person
import pl.dpotyralski.spockintroduction.rental.Rental
import spock.lang.Specification

import static pl.dpotyralski.spockintroduction.rental.CategoryType.PREMIUM

class _14_SpySupportTest extends Specification {

    def "should create spy and override method"() {
        given:
        Person person = Spy(Person, construtorArgs: ["name", "Damian"]) {
            getName() >> "NieDamian"
        }

        expect:
        person.getName() == "NieDamian"
    }

    def "should create spy from object and override method "() {
        given:
        Rental rental = new Rental("1", 2, new Movie("Matrix", PREMIUM))
        Rental rentalSpy = Spy(rental) {
            calculateChargeAmount() >> BigDecimal.TEN
        }

        expect:
        rentalSpy.calculateChargeAmount() == BigDecimal.TEN
    }

}
