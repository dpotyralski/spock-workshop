package pl.dpotyralski.spockintroduction.rental;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class ChargeResult {

    private final boolean charged;

}
