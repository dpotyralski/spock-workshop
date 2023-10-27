package pl.dpotyralski.spockintroduction.workshop.customer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerService {

    CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

}
