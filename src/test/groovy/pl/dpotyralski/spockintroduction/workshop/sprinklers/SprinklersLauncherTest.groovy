package pl.dpotyralski.spockintroduction.workshop.sprinklers

import pl.dpotyralski.spockintroduction.TimeProvider
import spock.lang.Specification
import spock.util.time.MutableClock

import java.time.Duration
import java.time.Instant

class SprinklersLauncherTest extends Specification {

    private MutableClock clock = new MutableClock(Instant.parse("2023-10-26T18:35:24.00Z"))
    private TimeProvider tp = new TimeProvider(clock)
    private SprinklersLauncher launcher = new SprinklersLauncher(tp)

    def "Should be able to mange sprinklers"() {
        when: "clock is set as above"
        launcher.toogle()

        then: "turning on sprinklers shouldn't be possible"
        launcher.isWorking() == false

        when:
        clock + Duration.ofHours(16)

        and: "turning on sprinklers at 10 is ok"
        launcher.toogle()

        then:
        launcher.isWorking() == true
    }
}
