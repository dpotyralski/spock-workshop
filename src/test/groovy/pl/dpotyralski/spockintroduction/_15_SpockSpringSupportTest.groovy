package pl.dpotyralski.spockintroduction

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.dpotyralski.spockintroduction.rental.CardProcessor
import spock.lang.Specification

@SpringBootTest
class _15_SpockSpringSupportTest extends Specification {

    @Autowired
    private CardProcessor cardProcessor

    def contextLoads() {
        expect:
        true
    }

}
