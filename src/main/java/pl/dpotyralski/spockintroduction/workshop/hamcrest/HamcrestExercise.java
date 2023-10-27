package pl.dpotyralski.spockintroduction.workshop.hamcrest;

import pl.dpotyralski.spockintroduction.rental.Person;

import java.util.Map;
import java.util.Random;

public class HamcrestExercise {

    private static final Random RANDOM = new Random();

    public String returnsEitherFooOrBar() {
        return RANDOM.nextInt(2) + 1 == 1 ? "foo" : "bar";
    }

    public String returnsStringWithWhitespaces() {
        return "More   spaces than needed";
    }

    public Person returnsPersonObject() {
        return new Person("James");
    }

    public String returnsSomeString() {
        return "The sun sets over the horizon, painting the sky in shades of orange and pink.";
    }

    public Map<String, String> returnsSomeMap() {
        return Map.of("food","hot-dog", "game", "Witcher 3");
    }

}
