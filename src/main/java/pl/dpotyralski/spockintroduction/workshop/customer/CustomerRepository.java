package pl.dpotyralski.spockintroduction.workshop.customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer save(Customer customer);

}
