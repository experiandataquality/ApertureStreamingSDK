package com.experian.aperture.streaming.client;

import net.bytebuddy.utility.RandomString;
import java.util.Random;

/**
 * To generate random string and number.
 */
public final class RandomGenerator {
    private RandomGenerator() { }

    public static String generateRandomString() {
        return new RandomString().nextString();
    }

    public static String generateRandomNumber() {
        return String.valueOf(new Random().nextInt());
    }
}
