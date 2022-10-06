package pl.dpotyralski.spockintroduction


import pl.dpotyralski.spockintroduction.rental.Movie
import spock.lang.Specification

import static pl.dpotyralski.spockintroduction.rental.CategoryType.PREMIUM

class _6c_DataDrivenTypeCoercionTest extends Specification {

    def "should do some type coercion"(String x, int y) {
        expect:
        x instanceof String
        y instanceof Integer

        where:
        x | y
        1 | "1"
        2 | "2"
        3 | "3"
    }

    def "should help with types"(Movie movie) {
        expect:
        movie.getCategory() == PREMIUM

        where:
        movie                           | _
        new Movie("Cast Away", PREMIUM) | _
    }

}