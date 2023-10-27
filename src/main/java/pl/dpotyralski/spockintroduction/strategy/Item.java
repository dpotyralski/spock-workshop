package pl.dpotyralski.spockintroduction.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Item {

    private BigDecimal price;

    public void newPrice(BigDecimal price) {
        this.price = price;
    }

}
