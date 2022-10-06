package pl.dpotyralski.spockintroduction

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import pl.dpotyralski.spockintroduction.rental.*
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration(classes = CardProcessorContextConfiguration)
class _17b_SpringMockingBeansTest extends Specification {

    @Autowired
    private BillingService billingService

    @Autowired
    private CardProcessor cardProcessor

    def "should use credit card processor implementation in charging process"() {
        given:
        CreditCard card = new CreditCard("5105105105105100", "12/23", 123)
        Rental rental = new Rental("1", 2, new Movie("Matrix", CategoryType.PREMIUM))

        when:
        boolean rentalCharged = billingService.chargeRental(rental, card)

        then:
        rentalCharged

        and:
        1 * cardProcessor.charge(_, _) >> ChargeResult.of(true)
    }


}
