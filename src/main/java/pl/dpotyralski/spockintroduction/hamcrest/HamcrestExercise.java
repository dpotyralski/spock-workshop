package pl.dpotyralski.spockintroduction.hamcrest;

import pl.dpotyralski.spockintroduction.rental.Person;

import java.util.Random;

public class HamcrestExercise {

    private final Random random = new Random();

    public String returnsEitherFooOrBar() {
        return random.nextInt(2) + 1 == 1 ? "foo" : "bar";
    }

    public String returnsStringWithWhitespaces() {
        return "More   spaces than needed";
    }

    public Person returnsPersonObject(){
        return new Person("James");
    }

}
