package pl.dpotyralski.spockintroduction


import pl.dpotyralski.spockintroduction.rental.*
import spock.lang.Retry
import spock.lang.Specification

class _23_RetryTest extends Specification {

    CardProcessor cardProcessor = Stub(CardProcessor)

    BillingService billingService = new BillingService(cardProcessor)

    @Retry
    def "should retry the charge attempt"() {
        given:
        Rental rental = new Rental("1", 2, new Movie("Matrix", CategoryType.PREMIUM))
        CreditCard card = new CreditCard("5105105105105100", "12/23", 123)

        cardProcessor.charge(_, _) >>> [{ throw new IllegalStateException() }, ChargeResult.of(true)]

        when:
        boolean chargeRental = billingService.chargeRental(rental, card)

        then:
        chargeRental
    }

    @Retry(exceptions = IllegalStateException)
    def "should retry the charge attempt on connection exception"() {
        given:
        Rental rental = new Rental("1", 2, new Movie("Matrix", CategoryType.PREMIUM))
        CreditCard card = new CreditCard("5105105105105100", "12/23", 123)

        and:
        cardProcessor.charge(_, _) >> { throw new IllegalStateException() } >> ChargeResult.of(true)

        when:
        boolean chargeRental = billingService.chargeRental(rental, card)

        then:
        chargeRental
    }
}
