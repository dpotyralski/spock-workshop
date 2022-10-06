package pl.dpotyralski.spockintroduction.customer;

import java.math.BigDecimal;

public interface BonusAssigner {

    boolean assignBonus(Customer customer, BigDecimal amount);

}
