package pl.dpotyralski.spockintroduction.rental;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public enum CategoryType {
    STANDARD(new BigDecimal(40)),
    PREMIUM(new BigDecimal(60));

    private final BigDecimal dayPrice;

    CategoryType(BigDecimal price) {
        this.dayPrice = price;
    }
}
