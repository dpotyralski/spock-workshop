package pl.dpotyralski.spockintroduction.workshop.customer


import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Subject

import java.time.LocalDate
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
        given:
        Customer customer = new Customer(id: UUID.randomUUID(), name: "Joe", country: "DENMARK")
        BigDecimal bonusAmount = new BigDecimal(100)

        when:
        customerBonusAssigner.assignBonus(customer, LocalDate.of(2021, 6, 5))

        then:
        1 * configuration.getHolidayBonus() >> bonusAmount
        1 * bonusAssigner.assignBonus(customer, bonusAmount)
    }

    def "Should assign regular bonus"() {
        //TODO
    }

}
