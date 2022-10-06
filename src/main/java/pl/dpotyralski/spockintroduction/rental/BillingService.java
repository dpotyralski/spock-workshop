package pl.dpotyralski.spockintroduction.rental;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
@AllArgsConstructor
public class BillingService {

    private final CardProcessor processor;

    public boolean chargeRental(Rental rental, CreditCard creditCard) {
        BigDecimal amount = rental.calculateChargeAmount();
        ChargeResult charge = processor.charge(creditCard, amount);
        return charge != null && charge.isCharged();
    }

    public void chargeRentals(Set<Rental> rentals, CreditCard creditCard) {
        rentals.forEach(rental -> processor.charge(creditCard, rental.calculateChargeAmount()));
    }

}
