package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.rental.*
import spock.lang.Specification
import spock.lang.Subject

class _9a_StubbingTest extends Specification {

    private JpaRepository jpaRepository = Stub(JpaRepository) {
        save(_ as Movie) >> { Movie movie -> movie }
    }

    @Subject
    private MovieDaoService sub = new MovieDaoService(jpaRepository)

    def "should charge call process for rental"() {
        given:
        def movie = new Movie("Title", CategoryType.PREMIUM)

        and: "stubbing"
        jpaRepository.save(_ as Movie) >> { Movie m -> movie }

        when:
        def save = sub.save(movie)

        then:
        save.getTitle() == "Title"
    }

}