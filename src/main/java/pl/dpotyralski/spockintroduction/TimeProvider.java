package pl.dpotyralski.spockintroduction;


import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
public class TimeProvider {

    private final Clock clock;

    public LocalDate date() {
        return LocalDate.now(clock);
    }

    public LocalTime time() {
        return LocalTime.now(clock);
    }

}
