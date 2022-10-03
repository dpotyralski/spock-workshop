package pl.dpotyralski.spockintroduction.rental;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
public class CreditCardProcessor implements CardProcessor {

    @Override
    public ChargeResult charge(CreditCard creditCard, BigDecimal amount) {
        log.info("Passed credit card: {} to be charged with amount: {}", creditCard, amount);
        return amount.compareTo(BigDecimal.TEN) <= 0 ? ChargeResult.of(true) : ChargeResult.of(false);
    }

}
