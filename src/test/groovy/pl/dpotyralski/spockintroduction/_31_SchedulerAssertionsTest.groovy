package pl.dpotyralski.spockintroduction

import org.spockframework.spring.SpringBean
import org.spockframework.spring.SpringSpy
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import pl.dpotyralski.spockintroduction.workshop.customer.Customer
import pl.dpotyralski.spockintroduction.workshop.customer.CustomerRepository
import pl.dpotyralski.spockintroduction.scheduler.SimpleTask
import spock.lang.Specification

@ActiveProfiles("h2")
@SpringBootTest
class _31_SchedulerAssertionsTest extends Specification {

    @SpringSpy
    private SimpleTask simpleTask;

    @SpringBean
    private CustomerRepository customerRepository = Mock()

    def "should insert customer as scheduled task action"() {
        given:
        Customer customer = new Customer(id: "6b5020fd-36f2-4389-ab02-893aec43dcc9", name: "John", country: "POLAND")

        when:
        simpleTask.work()

        then:
        1 * customerRepository.save(_ as Customer) >> customer
    }
}

