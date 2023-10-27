package pl.dpotyralski.spockintroduction.workshop.hamcrest

import pl.dpotyralski.spockintroduction.workshop.hamcrest.HamcrestExercise
import spock.lang.Ignore
import spock.lang.Specification

class HamcrestExerciseTest extends Specification {

    private HamcrestExercise hamcrestExercise = new HamcrestExercise()

    @Ignore
    def "Should get either foo or bar"() {
        //TODO
        expect:
        true

    }

    @Ignore
    def "Should be able to compare without whitespaces"() {
        //TODO
        expect:
        true
    }

    @Ignore
    def "Should be able to check that object has property name equal to James"() {
        //TODO
        expect:
        true
    }

    @Ignore
    def "Should verify if provided string start with `The sun sets`"() {
        //TODO
        expect:
        true
    }

    @Ignore
    def "Should provided map with `game` key and `food` entry with 7 characters long"() {
        //TODO
        expect:
        true
    }

}

