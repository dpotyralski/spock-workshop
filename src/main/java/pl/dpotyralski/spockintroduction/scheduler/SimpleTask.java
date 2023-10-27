package pl.dpotyralski.spockintroduction.scheduler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.dpotyralski.spockintroduction.workshop.customer.Customer;
import pl.dpotyralski.spockintroduction.workshop.customer.CustomerRepository;

import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
class SimpleTask {

    private final CustomerRepository customerRepository;

    @Scheduled(fixedRate = 1000)
    public void work() {
        log.info("Starting my task");
        Customer customer = new Customer();
        customer.setName(UUID.randomUUID().toString().substring(4));
        customer.setCountry("Poland");
        Customer saved = customerRepository.save(customer);
        log.info("Saving customer with id %s completed".formatted(saved.getId()));
    }

}
