package pl.dpotyralski.spockintroduction

import org.spockframework.spring.SpringBean
import org.springframework.boot.test.context.SpringBootTest
import pl.dpotyralski.spockintroduction.rental.CardProcessor
import pl.dpotyralski.spockintroduction.rental.ChargeResult
import pl.dpotyralski.spockintroduction.rental.CreditCard
import spock.lang.Specification

@SpringBootTest
class _18_SpringMockingBeansAnnotationDrivenTest extends Specification {

    @SpringBean
    private CardProcessor cardProcessor = Mock(CardProcessor) {
        charge(_, _) >> ChargeResult.of(true)
    }

    def "should use credit card processor implementation in charging process"() {
        when:
        ChargeResult charge = cardProcessor.charge(new CreditCard("5105105105105100", "12/23", 123), amount)

        then:
        charge.isCharged() == expectedResult

        where:
        amount                  | expectedResult
        new BigDecimal(1)       | true
        BigDecimal.TEN          | true
        BigDecimal.valueOf(11)  | true
        BigDecimal.valueOf(100) | true
    }


}
