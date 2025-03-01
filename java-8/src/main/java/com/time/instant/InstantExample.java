package com.time.instant;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class InstantExample {

    public static void main(String[] args) {
        // Now
        Instant instant = Instant.now();
        System.out.println(instant);

        //
        instant.plus(1, TimeUnit.MINUTES.toChronoUnit());
    }

}
