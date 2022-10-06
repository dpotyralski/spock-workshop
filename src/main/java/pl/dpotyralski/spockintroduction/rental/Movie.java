package pl.dpotyralski.spockintroduction.rental;

import lombok.Value;
import pl.dpotyralski.spockintroduction.rental.CategoryType;

@Value
public class Movie {

    String title;
    CategoryType category;

    public String getTitleWithCategory() {
        return title + " from " + category + " category";
    }

}