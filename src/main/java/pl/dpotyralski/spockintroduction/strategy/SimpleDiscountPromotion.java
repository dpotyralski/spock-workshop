package pl.dpotyralski.spockintroduction.strategy;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SimpleDiscountPromotion implements Promotion {

    @Override
    public Item apply(Item item) {
        item.newPrice(item.getPrice().multiply(new BigDecimal("0.95")));
        return item;
    }

    @Override
    public boolean enabled() {
        return true;
    }

    @Override
    public int order() {
        return 1;
    }

}
