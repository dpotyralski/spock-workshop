package pl.dpotyralski.spockintroduction.workshop.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerProvider {

    private final CustomerRepository customerJPARepository;

    public List<Customer> getAllCustomers() {
        return customerJPARepository.findAll();
    }

}
