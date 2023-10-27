package pl.dpotyralski.spockintroduction.workshop.customer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerProvider customerProvider;

    @GetMapping("/customers")
    public ResponseEntity<CustomersResponse> customers() {

        List<CustomersResponse.CustomerResponse> customers = customerProvider.getAllCustomers()
                .stream()
                .map(c -> new CustomersResponse.CustomerResponse(c.getId().toString(), c.getName()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(CustomersResponse.from(customers));
    }

}
