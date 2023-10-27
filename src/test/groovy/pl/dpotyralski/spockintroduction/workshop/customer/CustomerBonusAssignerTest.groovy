package pl.dpotyralski.spockintroduction.workshop.customer


import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Subject

import java.time.Month
import java.time.MonthDay

@Ignore
class CustomerBonusAssignerTest extends Specification {

    BankHolidaysProvider bankHolidaysProvider = Stub(BankHolidaysProvider) {
        bankHolidaysByCountry("POLAND") >> [MonthDay.of(Month.MAY, 3)]
        bankHolidaysByCountry("DENMARK") >> [MonthDay.of(Month.JUNE, 5)]
    }

    BonusAssigner bonusAssigner = Mock(BonusAssigner)
    BonusConfiguration configuration = Mock(BonusConfiguration)

    @Subject
    CustomerBonusAssigner customerBonusAssigner =
            new CustomerBonusAssigner(bankHolidaysProvider, configuration, bonusAssigner)

    def "Should assign holiday bonus"() {
        //TODO
    }

    def "Should assign regular bonus"() {
        //TODO
    }

}
