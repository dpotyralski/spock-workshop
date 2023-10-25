package pl.dpotyralski.spockintroduction

import org.spockframework.spring.xml.SpockMockFactoryBean
import org.springframework.beans.factory.FactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.test.context.ActiveProfiles
import pl.dpotyralski.spockintroduction.rental.*
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("h2")
class _17_SpringMockingBeansTest extends Specification {

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

    @TestConfiguration
    static class DetachedJavaConfig {

//        DetachedMockFactory mockFactory = new DetachedMockFactory()
//
//        @Bean
//        CardProcessor cardProcessorStub() {
//            return mockFactory.Mock(CardProcessor.class)
//        }

        @Bean
        @Primary
        FactoryBean<CardProcessor> cardProcessorStub() {
            return new SpockMockFactoryBean<>(CardProcessor.class)
        }

    }


}
