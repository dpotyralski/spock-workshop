package pl.dpotyralski.spockintroduction


import spock.lang.Specification
import spock.lang.Timeout

import java.util.concurrent.TimeUnit

class _25_TimeoutTest extends Specification {

    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    def "I better be quick"() {
        expect:
        true
    }
}
