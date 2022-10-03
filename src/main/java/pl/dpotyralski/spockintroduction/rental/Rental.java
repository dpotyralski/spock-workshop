package pl.dpotyralski.spockintroduction.rental;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Rental {

    String id;
    int days;
    Movie movie;

    public BigDecimal calculateChargeAmount() {
        return BigDecimal.valueOf(days).multiply(movie.getCategory().getDayPrice());
    }

}
