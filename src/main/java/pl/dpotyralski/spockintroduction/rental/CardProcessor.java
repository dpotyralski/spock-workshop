package pl.dpotyralski.spockintroduction.rental;

import java.math.BigDecimal;

public interface CardProcessor {

    ChargeResult charge(CreditCard creditCard, BigDecimal amount);

}
