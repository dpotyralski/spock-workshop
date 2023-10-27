package pl.dpotyralski.spockintroduction.strategy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dpotyralski.spockintroduction.TimeProvider;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
class HappyDayPromotion implements Promotion {

    private final TimeProvider timeProvider;

    @Override
    public Item apply(Item item) {
        if (timeProvider.date().getDayOfMonth() % 2 == 0) {
            item.newPrice(item.getPrice().multiply(new BigDecimal("0.80")));
        }
        return item;
    }

    @Override
    public boolean enabled() {
        return true;
    }

    @Override
    public int order() {
        return 0;
    }
}
