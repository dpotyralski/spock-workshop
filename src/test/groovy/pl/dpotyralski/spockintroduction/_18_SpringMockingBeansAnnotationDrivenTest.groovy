package pl.dpotyralski.spockintroduction

import org.spockframework.spring.ScanScopedBeans
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import pl.dpotyralski.spockintroduction.rental.BillingService
import pl.dpotyralski.spockintroduction.rental.CardProcessor
import pl.dpotyralski.spockintroduction.rental.CategoryType
import pl.dpotyralski.spockintroduction.rental.ChargeResult
import pl.dpotyralski.spockintroduction.rental.CreditCard
import pl.dpotyralski.spockintroduction.rental.Movie
import pl.dpotyralski.spockintroduction.rental.Rental
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("h2")
class _18_SpringMockingBeansAnnotationDrivenTest extends Specification {

    @SpringBean
    private CardProcessor cardProcessor = Mock(CardProcessor)

    @Autowired
    private BillingService billingService

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
