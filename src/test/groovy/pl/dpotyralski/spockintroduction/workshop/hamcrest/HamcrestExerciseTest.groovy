package pl.dpotyralski.spockintroduction.workshop.hamcrest

import spock.lang.Specification

import static org.hamcrest.Matchers.allOf
import static org.hamcrest.Matchers.equalTo
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace
import static org.hamcrest.Matchers.hasEntry
import static org.hamcrest.Matchers.hasKey
import static org.hamcrest.Matchers.hasLength
import static org.hamcrest.Matchers.hasProperty
import static org.hamcrest.Matchers.is
import static org.hamcrest.Matchers.oneOf
import static org.hamcrest.Matchers.startsWith
import static spock.util.matcher.HamcrestSupport.that

class HamcrestExerciseTest extends Specification {

    private HamcrestExercise hamcrestExercise = new HamcrestExercise()

    def "Should get either foo or bar"() {
        expect:
        that(hamcrestExercise.returnsEitherFooOrBar(), is(oneOf("foo", "bar")))
    }

    def "Should be able to compare without whitespaces"() {
        expect:
        that(hamcrestExercise.returnsStringWithWhitespaces(), equalToCompressingWhiteSpace("More spaces than needed"))
    }

    def "Should be able to check that object has property name equal to James"() {
        expect:
        that(hamcrestExercise.returnsPersonObject(), hasProperty("name", equalTo("James")))
    }

    def "Should verify if provided string start with `The sun sets`"() {
        expect:
        that(hamcrestExercise.returnsSomeString(), startsWith("The sun sets"))
    }

    def "Should provided map with `game` key and `food` entry with 7 characters long"() {
        expect:
        that(hamcrestExercise.returnsSomeMap(), allOf(hasKey("game"), hasEntry(equalTo("food"), hasLength(7))))
    }

}

