package pl.dpotyralski.spockintroduction

import spock.lang.Specification

import static org.hamcrest.Matchers.contains
import static org.hamcrest.Matchers.containsInAnyOrder
import static org.hamcrest.Matchers.hasEntry
import static org.hamcrest.Matchers.hasItem
import static org.hamcrest.Matchers.hasKey
import static org.hamcrest.Matchers.startsWith
import static spock.util.matcher.HamcrestSupport.that

class _30_HamcrestAssertionsTest extends Specification {

    def "Should be able to use hamcrest contains and containsInAnyOrder matchers with `that`"() {
        given:
        ArrayList<String> characters = ["a", "b", "c"]

        expect:
        that(characters, contains("a", "b", "c"))
        that(characters, containsInAnyOrder("c", "b", "a",))
    }

    def "Should be able to use hasItem and startsWith matchers"() {
        given:
        ArrayList<String> characters = ["abc", "bcd", "cde"]

        expect:
        characters hasItem(startsWith("bc"))
    }

    def "Should be able to use hamcrest map matchers"() {
        given:
        Map<String, Integer> map = ["a": 1, "b": 2, "c": 3]

        expect:
        map hasKey("b")
        map hasEntry("c", 3)
    }


}


