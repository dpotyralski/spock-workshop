package pl.dpotyralski.spockintroduction.workshop.sprinklers

import pl.dpotyralski.spockintroduction.TimeProvider
import spock.lang.Ignore
import spock.lang.Specification
import spock.util.time.MutableClock

import java.time.Instant

class SprinklersLauncherTest extends Specification {

    private MutableClock clock = new MutableClock(Instant.parse("2023-10-26T18:35:24.00Z"))
    private TimeProvider tp = new TimeProvider(clock)
    private SprinklersLauncher launcher = new SprinklersLauncher(tp)

    @Ignore
    def "Should be able to mange sprinklers"() {
        //TODO
        expect:
        true
    }

}
