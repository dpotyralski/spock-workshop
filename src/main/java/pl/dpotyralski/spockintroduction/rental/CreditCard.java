package pl.dpotyralski.spockintroduction.rental;

import lombok.Value;

@Value
public class CreditCard {

    String number;
    String exp;
    int cvc;

}
