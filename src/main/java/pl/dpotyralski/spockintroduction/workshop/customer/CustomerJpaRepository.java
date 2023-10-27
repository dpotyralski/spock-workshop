package pl.dpotyralski.spockintroduction.workshop.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerJpaRepository extends JpaRepository<Customer, UUID>, CustomerRepository {

}
