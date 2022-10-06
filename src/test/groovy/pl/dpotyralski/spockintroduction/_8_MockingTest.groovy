package pl.dpotyralski.spockintroduction


import pl.dpotyralski.spockintroduction.rental.*
import spock.lang.Specification
import spock.lang.Subject

class _8_MockingTest extends Specification {

    private CardProcessor cardProcessor = Mock(CardProcessor)

    @Subject
    private BillingService sub = new BillingService(cardProcessor)

    def "should charge call process for rental"() {
        given:
        Rental rental = new Rental("1", 2, new Movie("Matrix", CategoryType.PREMIUM))
        CreditCard card = new CreditCard("5105105105105100", "12/23", 123)

        when:
        sub.chargeRental(rental, card)

        then:
        1 * cardProcessor.charge(card, new BigDecimal("120"))

        and:
        0 * _
    }

    def "should charge call process for more rentals"() {
        given:
        Rental rental = new Rental("1", 2, new Movie("Matrix", CategoryType.PREMIUM))
        Rental rental2 = new Rental("2", 2, new Movie("Lord of Rings", CategoryType.STANDARD))

        and:
        CreditCard card = new CreditCard("5105105105105100", "12/23", 123)

        when:
        sub.chargeRentals([rental2, rental] as Set, card)

        then:
        1 * cardProcessor.charge(card, new BigDecimal("120"))
        1 * cardProcessor.charge(card, new BigDecimal("80"))
    }

    def "should charge call process for right card number"() {
        given:
        Rental rental = new Rental("1", 2, new Movie("Matrix", CategoryType.PREMIUM))

        and:
        CreditCard creditCard = new CreditCard("5105105105105100", "12/23", 123)

        when:
        sub.chargeRental(rental, creditCard)

        then:
        1 * cardProcessor.charge({ CreditCard card -> card.getNumber().endsWith("5100") }, new BigDecimal("120"))

        and:
        0 * _
    }

    def "should charge call process for more rentals in a proper sequence"() {
        given:
        Rental rental = new Rental("1", 2, new Movie("Matrix", CategoryType.PREMIUM))
        Rental rental2 = new Rental("2", 2, new Movie("Lord of Rings", CategoryType.STANDARD))

        and:
        CreditCard card = new CreditCard("5105105105105100", "12/23", 123)

        when:
        sub.chargeRentals([rental, rental2] as Set, card)

        then:
        1 * cardProcessor.charge(card, new BigDecimal("120"))

        then:
        1 * cardProcessor.charge(card, new BigDecimal("80"))

        and:
        0 * _
    }

}