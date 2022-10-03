package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.rental.*
import spock.lang.Specification
import spock.lang.Subject

class _13_StubbingAndMockingTest extends Specification {

    private CardProcessor cardProcessor = Mock(CardProcessor)

    @Subject
    private BillingService sub = new BillingService(cardProcessor)

    def "should charge call process for rental"() {
        given:
        CreditCard card = new CreditCard("5105105105105100", "12/23", 123)
        Rental rental = new Rental("1", 2, new Movie("Matrix", CategoryType.PREMIUM))

        when:
        boolean result = sub.chargeRental(rental, card)

        then:
        result
        1 * cardProcessor.charge(card, new BigDecimal(120)) >> new ChargeResult(true)
    }

    def "should additionally check interactions"() {
        given:
        CreditCard card = new CreditCard("5105105105105100", "12/23", 123)
        Rental rental = new Rental("1", 2, new Movie("Matrix", CategoryType.PREMIUM))

        when:
        boolean result = sub.chargeRental(rental, card)

        then:
        result

        interaction {
            verifyInteractions(card)
        }
    }

    def verifyInteractions(CreditCard card) {
        1 * cardProcessor.charge(card, new BigDecimal(120)) >> new ChargeResult(true)
        0 * _
    }

}