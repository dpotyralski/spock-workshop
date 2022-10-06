package pl.dpotyralski.spockintroduction

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import pl.dpotyralski.spockintroduction.rental.CardProcessor
import spock.mock.DetachedMockFactory

@TestConfiguration
class CardProcessorContextConfiguration {

    DetachedMockFactory mockFactory = new DetachedMockFactory()

    @Bean
    @Primary
    CardProcessor cardProcessorStub() {
        return mockFactory.Mock(CardProcessor.class)
    }

}
