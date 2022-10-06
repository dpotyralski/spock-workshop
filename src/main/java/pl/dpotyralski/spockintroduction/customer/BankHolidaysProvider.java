package pl.dpotyralski.spockintroduction.customer;

import java.time.MonthDay;
import java.util.List;

public interface BankHolidaysProvider {

    List<MonthDay> bankHolidaysByCountry(String country);

}
