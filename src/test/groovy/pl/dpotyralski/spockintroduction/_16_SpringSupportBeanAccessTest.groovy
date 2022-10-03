package pl.dpotyralski.spockintroduction

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.dpotyralski.spockintroduction.rental.CardProcessor
import pl.dpotyralski.spockintroduction.rental.ChargeResult
import pl.dpotyralski.spockintroduction.rental.CreditCard
import spock.lang.Specification

@SpringBootTest
class _16_SpringSupportBeanAccessTest extends Specification {

    @Autowired
    private CardProcessor cardProcessor

    def "should use credit card processor implementation in charging process"() {
        when:
        ChargeResult charge = cardProcessor.charge(new CreditCard("5105105105105100", "12/23", 123), amount)

        then:
        charge.isCharged() == expectedResult

        where:
        amount                  | expectedResult
        new BigDecimal(1)       | true
        BigDecimal.TEN          | true
        BigDecimal.valueOf(11)  | false
        BigDecimal.valueOf(100) | false
    }


}
