package pl.dpotyralski.spockintroduction


import pl.dpotyralski.spockintroduction.rental.*
import spock.lang.Specification
import spock.lang.Subject

class _10_StubbingInContextTest extends Specification {

    private CardProcessor cardProcessor = Stub(CardProcessor) {
        charge(_ as CreditCard, BigDecimal.valueOf(120)) >> new ChargeResult(true)
        charge()
    }

    @Subject
    private BillingService sub = new BillingService(cardProcessor)

    def "should charge call process for rental"() {
        given:
        CreditCard card = new CreditCard("5105105105105100", "12/23", 123)
        Rental rental = new Rental("1", 2, new Movie("Matrix", CategoryType.PREMIUM))

        expect:
        sub.chargeRental(rental, card)
    }

}