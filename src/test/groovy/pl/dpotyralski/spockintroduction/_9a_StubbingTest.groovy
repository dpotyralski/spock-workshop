package pl.dpotyralski.spockintroduction

import pl.dpotyralski.spockintroduction.workshop.customer.Customer
import pl.dpotyralski.spockintroduction.workshop.customer.CustomerRepository
import pl.dpotyralski.spockintroduction.workshop.customer.CustomerService
import spock.lang.Specification
import spock.lang.Subject

class _9a_StubbingTest extends Specification {

    private CustomerRepository customerRepository = Stub(CustomerRepository)

    @Subject
    private CustomerService sub = new CustomerService(customerRepository)

    def "should call save method and return passed value"() {
        given:
        Customer customer = new Customer(id: UUID.randomUUID(), name: "John", country: "POLAND")

        and: "stubbing"
        customerRepository.save(_ as Customer) >> { Customer c -> customer }

        when:
        Customer saved = sub.save(customer)

        then:
        saved.getName() == "John"
    }

}