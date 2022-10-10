package pl.dpotyralski.spockintroduction.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerProvider {

    private final CustomerJpaRepository customerJPARepository;

    public List<Customer> getAllCustomers() {
        return customerJPARepository.findAll();
    }

}
