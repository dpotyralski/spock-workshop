package pl.dpotyralski.spockintroduction


import pl.dpotyralski.spockintroduction.rental.Movie
import spock.lang.Specification

import static pl.dpotyralski.spockintroduction.rental.CategoryType.STANDARD

class _6b_DataDrivenTest extends Specification {

    def "should present data tables along with data pipes and variable assignments"() {
        when:
        println titleWithCategory
        Movie movie = new Movie(title, STANDARD)

        then:
        movie.title == expectedTitle

        where:
        title          || expectedTitle
        'Spider Man'   || 'Spider Man'
        'Matrix'       || 'Matrix'
        'Pulp Fiction' || 'Pulp Fiction'
        'xXx'          || 'xXx'

        category << [STANDARD, STANDARD, STANDARD, STANDARD]

        titleWithCategory = "${title} from ${category}"
    }


}