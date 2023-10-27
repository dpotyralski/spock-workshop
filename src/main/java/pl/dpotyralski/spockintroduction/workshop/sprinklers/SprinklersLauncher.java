package pl.dpotyralski.spockintroduction.workshop.sprinklers;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.dpotyralski.spockintroduction.TimeProvider;

import java.time.LocalTime;

@RequiredArgsConstructor
class SprinklersLauncher {

    private final TimeProvider timeProvider;

    @Getter
    private boolean working;

    public void toogle() {
        LocalTime startTime = LocalTime.of(8, 0);
        LocalTime endTime = LocalTime.of(14, 0);

        LocalTime currentTime = timeProvider.time();
        working = currentTime.isAfter(startTime) && currentTime.isBefore(endTime);
    }

}
