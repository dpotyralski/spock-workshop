package pl.dpotyralski.spockintroduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
class TimeProviderConfiguration {

    @Bean
    public TimeProvider timeProvider() {
        return new TimeProvider(Clock.systemDefaultZone());
    }

}
