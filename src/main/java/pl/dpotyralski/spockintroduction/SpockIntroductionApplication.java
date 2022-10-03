package pl.dpotyralski.spockintroduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.dpotyralski.spockintroduction.rental.CardProcessor;
import pl.dpotyralski.spockintroduction.rental.CreditCardProcessor;

@SpringBootApplication
public class SpockIntroductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpockIntroductionApplication.class, args);
    }

    @Bean
    public CardProcessor creditCardProcessor() {
        return new CreditCardProcessor();
    }


}
