package pl.dpotyralski.spockintroduction.customer;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;

@AllArgsConstructor
public class CustomerBonusAssigner {

    private final BankHolidaysProvider bankHolidaysProvider;
    private final BonusConfiguration configuration;
    private final BonusAssigner bonusAssigner;

    public boolean assignBonus(Customer customer, LocalDate localDate) {
        List<MonthDay> holidays = bankHolidaysProvider.bankHolidaysByCountry(customer.getCountry());

        if (holidays.stream().anyMatch(monthDay -> monthDay.equals(MonthDay.from(localDate)))) {
            BigDecimal holidayBonus = configuration.getHolidayBonus();
            return bonusAssigner.assignBonus(customer, holidayBonus);
        }

        BigDecimal regularBonus = configuration.getRegularBonus();
        return bonusAssigner.assignBonus(customer, regularBonus);
    }

}
