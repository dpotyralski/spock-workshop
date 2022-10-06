package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.rental.CategoryType
import pl.dpotyralski.spockintroduction.rental.Movie
import spock.lang.Specification

import static pl.dpotyralski.spockintroduction.rental.CategoryType.PREMIUM
import static pl.dpotyralski.spockintroduction.rental.CategoryType.STANDARD

class _6_DataDrivenTest extends Specification {

    def "should check if given character `#character` is in set"() {
        given:
        Set<String> characters = ['a', 'b', 'c', 'd', 'e'] as Set

        expect:
        character in characters

        where:
        character << ['a', 'b', 'c']
    }

    def "should get the maximum of two numbers"(int a, int b, int c) {
        expect:
        Math.max(a, b) == c

        where:
        a << [5, 3]
        b << [1, 9]
        c << [5, 9]
    }

    def "should get the maximum of two numbers from list of list"() {
        expect:
        Math.max(a, b) == c

        where:
        [a, b, c] << [[5, 3, 5], [1, 9, 9], [3, 1, 3]]
    }

    def "should check if given character #character is in #resultCharacersSet set"() {
        expect:
        character in resultCharacersSet

        where:
        character << ['a', 'b', 'c']
        resultCharacersSet << [['a', 'b', 'c', 'd'] as Set, ['d', 'c', 'b', 'a'] as Set, ['d', 'c', 'b', 'a'] as Set]
    }

    def "should verify if Movie has title with one parameter table"() {
        when:
        Movie movie = new Movie(title, STANDARD)

        then:
        movie.title == expectedTitle

        where:
        title          | category || expectedTitle
        'Spider Man'   | STANDARD || 'Spider Man'
        'Matrix'       | STANDARD || 'Matrix'
        'Pulp Fiction' | STANDARD || 'Pulp Fiction'
        'xXx'          | STANDARD || 'xXx'
    }

    def "should verify if movie #title has expected title with category #titleWithCategory"() {
        expect:
        movie.getTitleWithCategory() == titleWithCategory

        where:
        title          | category | movie                        || titleWithCategory
        "Spider Man"   | STANDARD | createMovie(title, category) || "Spider Man from ${category} category"
        "Matrix"       | PREMIUM  | createMovie(title, category) || "Matrix from ${category} category"
        "Pulp Fiction" | STANDARD | createMovie(title, category) || "Pulp Fiction from ${category} category"
    }

    private def createMovie(String title, CategoryType categoryType) {
        new Movie(title, categoryType)
    }

}