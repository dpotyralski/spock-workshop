package pl.dpotyralski.spockintroduction

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import pl.dpotyralski.spockintroduction.customer.Customer
import pl.dpotyralski.spockintroduction.customer.CustomerJpaRepository
import spock.lang.Specification

@DataJpaTest
@Testcontainers
@ActiveProfiles("postgresql")
class _18_SpringDataTest extends Specification {

    static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:16.0")

    @Autowired
    private CustomerJpaRepository customersRepository

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        postgreSQLContainer.start()
        registry.add("spring.datasource.url", () -> postgreSQLContainer.getJdbcUrl())
        registry.add("spring.datasource.username", () -> postgreSQLContainer.getUsername())
        registry.add("spring.datasource.password", () -> postgreSQLContainer.getPassword())
        registry.add("spring.datasource.database", () -> postgreSQLContainer.getDatabaseName())
    }

//    def "should use credit card processor implementation in charging process"() {
//        when:
//        List<Customer> customers = customersRepository.findAll()
//
//        then:
//        !customers.isEmpty()
//    }

    def "should use credit card processor implementation in charging process"() {
        when:
        def customer = customersRepository.save(createTestCustomer())
        def id = customersRepository.findById(customer.getId()).get()

        then:
        customer === id
    }

    private Customer createTestCustomer() {
        return new Customer(name: "Damian")
    }

}
