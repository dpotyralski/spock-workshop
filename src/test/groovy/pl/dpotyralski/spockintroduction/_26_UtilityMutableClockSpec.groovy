package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.workshop.customer.AgeFilter
import spock.lang.Specification
import spock.lang.Subject
import spock.util.time.MutableClock

import java.time.Duration
import java.time.ZoneId
import java.time.ZonedDateTime

class _26_UtilityMutableClockSpec extends Specification {

    ZonedDateTime defaultTime = defaultZoneDateTime()
    MutableClock clock = new MutableClock(defaultTime)

    @Subject
    AgeFilter ageValidator = new AgeFilter(clock, 18)

    def "should move clock"() {
        given:
        def birthdate = defaultTime.minusYears(18).plusDays(1).toLocalDate()

        expect:
        !ageValidator.test(birthdate)

        when:
        clock + Duration.ofDays(1)

        then:
        ageValidator.test(birthdate)
    }

    private ZonedDateTime defaultZoneDateTime() {
        ZonedDateTime.of(2018, 10, 8, 0, 0, 0, 0, ZoneId.of('UTC'))
    }

}