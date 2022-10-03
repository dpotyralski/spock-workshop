package pl.dpotyralski.spockintroduction

import org.spockframework.spring.xml.SpockMockFactoryBean
import org.springframework.beans.factory.FactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import pl.dpotyralski.spockintroduction.rental.CardProcessor
import pl.dpotyralski.spockintroduction.rental.ChargeResult
import pl.dpotyralski.spockintroduction.rental.CreditCard
import spock.lang.Specification

@SpringBootTest
class _17_SpringMockingBeansTest extends Specification {

    @Autowired
    @Qualifier("cardProcessorStub")
    private CardProcessor cardProcessor

    def "should use credit card processor implementation in charging process"() {
        when:
        ChargeResult charge = cardProcessor.charge(new CreditCard("5105105105105100", "12/23", 123), amount)

        then:
        charge.isCharged() == expectedResult

        and:
        1 * cardProcessor.charge(_, _) >> ChargeResult.of(true)

        where:
        amount                  | expectedResult
        new BigDecimal(1)       | true
        BigDecimal.TEN          | true
        BigDecimal.valueOf(11)  | true
        BigDecimal.valueOf(100) | true
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
        FactoryBean<CardProcessor> cardProcessorStub() {
            return new SpockMockFactoryBean<>(CardProcessor.class)
        }

    }


}
