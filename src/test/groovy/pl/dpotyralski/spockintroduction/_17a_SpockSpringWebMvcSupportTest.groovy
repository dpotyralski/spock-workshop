package pl.dpotyralski.spockintroduction

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import pl.dpotyralski.spockintroduction.workshop.customer.Customer
import pl.dpotyralski.spockintroduction.workshop.customer.CustomerProvider
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
@ActiveProfiles("h2")
class _17a_SpockSpringWebMvcSupportTest extends Specification {

    @Autowired
    private MockMvc mvc

    @Autowired
    CustomerProvider customerProvider

    def "should get some customers from h2 databse"() {
        given:
        customerProvider.getAllCustomers() >>
                [new Customer(id: UUID.fromString("ae35d569-cedf-4f29-a7d0-14ee5839c4dd"), name: "James")]

        expect:
        mvc.perform(MockMvcRequestBuilders.get("/customers"))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString == '''{"customers":[{"id":"ae35d569-cedf-4f29-a7d0-14ee5839c4dd","name":"James"}]}'''
    }

    @TestConfiguration
    static class MockConfig {
        def detachedMockFactory = new DetachedMockFactory()

        @Bean
        CustomerProvider customerProvider() {
            return detachedMockFactory.Stub(CustomerProvider)
        }
    }

}
