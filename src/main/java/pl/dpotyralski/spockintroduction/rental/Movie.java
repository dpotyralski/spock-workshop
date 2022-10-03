package pl.dpotyralski.spockintroduction.rental;

import lombok.Value;

@Value
public class Movie {

    String title;
    CategoryType category;

    public String getTitleWithCategory() {
        return title + " from " + category + " category";
    }

}