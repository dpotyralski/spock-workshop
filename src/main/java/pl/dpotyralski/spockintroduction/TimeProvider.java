package pl.dpotyralski.spockintroduction;


import lombok.AllArgsConstructor;

import java.time.Clock;
import java.time.LocalDate;

@AllArgsConstructor
public class TimeProvider {

    Clock clock;

    public LocalDate now() {
        return LocalDate.now(clock);
    }

}
