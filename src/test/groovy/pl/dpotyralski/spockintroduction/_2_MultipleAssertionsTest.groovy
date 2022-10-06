package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.rental.Movie
import pl.dpotyralski.spockintroduction.rental.Rental
import spock.lang.Specification

import static pl.dpotyralski.spockintroduction.rental.CategoryType.STANDARD

class _2_MultipleAssertionsTest extends Specification {

    def "should match two assertions"() {
        given:
        Rental rental = getTestSubject()

        when:
        Movie movie = rental.movie

        then:
        movie.getTitle() == "Matrix"
        movie.getCategory() == STANDARD
    }

    def "should match with helper method"() {
        given:
        Rental rental = getTestSubject()

        when:
        Movie movie = rental.movie

        then:
        shouldMatchMatrix(movie)
    }

    def shouldMatchMatrix(Movie movie) {
        assert movie.title == "Matrix"
        assert movie.category == STANDARD
    }

    def "should match with `with` method"() {
        given:
        Rental rental = getTestSubject()

        when:
        Movie movie = rental.movie

        then:
        with(movie) {
            title == "Matrix"
            category == STANDARD
        }
    }

    def "should match with `verifyAll` method"() {
        given:
        Rental rental = getTestSubject()

        when:
        Movie movie = rental.movie

        then:
        verifyAll(movie) {
            title == "Matrix"
            category == STANDARD
        }
    }

    private static Rental getTestSubject(Movie movie = new Movie("Matrix", STANDARD)) {
        new Rental("4be5fbaa-7da2-4b47-a999-9e1e223a57f3", 2, movie)
    }

}