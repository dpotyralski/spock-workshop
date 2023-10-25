package pl.dpotyralski.spockintroduction.hamcrest

import spock.lang.Specification

class HamcrestExerciseTest extends Specification {

    private HamcrestExercise hamcrestExercise = new HamcrestExercise()

    def "Should get either foo or bar"() {
//        expect:
        //TODO
//        that(hamcrestExercise.returnsEitherFooOrBar(), is(oneOf("foo", "bar")))
    }

    def "Should be able to compare without whitespaces"() {
//        expect:
        //TODO
//        that(hamcrestExercise.returnsStringWithWhitespaces(), equalToCompressingWhiteSpace("More spaces than needed"))
    }

    def "Should be able to check object properties"() {
//        TODO
//        expect:
//        that(hamcrestExercise.returnsPersonObject(), hasProperty("name", equalTo("James")))
    }


}

