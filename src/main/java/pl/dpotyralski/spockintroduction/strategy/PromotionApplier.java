package pl.dpotyralski.spockintroduction.strategy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PromotionApplier {

    private final List<Promotion> promotions;

    public Item apply(Item item) {
        Collection<Promotion> collect = promotions.stream()
                .filter(Promotion::enabled)
                .sorted(Comparator.comparingInt(Promotion::order))
                .toList();

        collect.forEach(promotion -> promotion.apply(item));
        return item;
    }

}
