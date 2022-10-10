package pl.dpotyralski.spockintroduction.customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer save(Customer customer);

}
