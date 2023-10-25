package pl.dpotyralski.spockintroduction


import spock.lang.Specification

class _27_CollectionConditionsSpec extends Specification {

    def "should use lenient match"() {
        given:
        ArrayList<Integer> integers = [2, 2, 1, 3, 3]

        expect:
        integers =~ [2, 1, 3]
    }

    def "should use strict match"() {
        given:
        ArrayList<Integer> integers = [1, 2, 3]

        expect:
        integers ==~ [3, 2, 1]
    }


}
