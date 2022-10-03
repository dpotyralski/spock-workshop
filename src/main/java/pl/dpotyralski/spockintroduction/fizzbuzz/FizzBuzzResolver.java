package pl.dpotyralski.spockintroduction.fizzbuzz;

public class FizzBuzzResolver {

    public FizzBuzzResolver() {
        System.out.println("Hello from constructor");
    }

    public String resolve(int value) {
        if (value % 3 == 0 && value % 5 == 0) {
            return "FizzBuzz";
        }

        if (value % 3 == 0) {
            return "Fizz";
        }

        if (value % 5 == 0) {
            return "Buzz";
        }

        return String.valueOf(value);
    }


}
