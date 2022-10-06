package pl.dpotyralski.spockintroduction.customer;

import java.math.BigDecimal;

public interface BonusConfiguration {

    BigDecimal getRegularBonus();

    BigDecimal getHolidayBonus();


}
