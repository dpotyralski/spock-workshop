package pl.dpotyralski.spockintroduction.strategy

import org.spockframework.spring.SpringBean
import org.spockframework.spring.SpringSpy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import pl.dpotyralski.spockintroduction.TimeProvider
import spock.lang.Specification

import java.time.LocalDate

@ActiveProfiles("h2")
@SpringBootTest
class PromotionApplierTest extends Specification {

    @Autowired
    private PromotionApplier promotionApplier

    @SpringBean
    private TimeProvider timeProvider = Mock() {
        date() >> LocalDate.of(2023, 04, 04)
    }

//    @SpringBean
//    @SpringSpy
//    SimpleDiscountPromotion simpleDiscountPromotion

    def "Should apply promotions to passed item"() {
        given:
        Item item = new Item(new BigDecimal("100"))
//        simpleDiscountPromotion.enabled() >> true

        when:
        Item actualItem = promotionApplier.apply(item)

        then:
        actualItem.getPrice() == new BigDecimal(76)
    }

//    @TestConfiguration
//    static class DetachedJavaConfig {
//
//        @Bean
//        Promotion additionalPromotion() {
//            return new Promotion() {
//                @Override
//                Item apply(Item item) {
//                    item.newPrice(item.getPrice().multiply(new BigDecimal("0.10")));
//                    return item
//                }
//
//                @Override
//                boolean enabled() {
//                    return true
//                }
//            }
//        }
//    }
}
