package com.bobocode.fp;

import com.bobocode.util.ExerciseNotCompletedException;

import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * {@link PrimeNumbers} provides an API to work with prime numbers. The implementation is based on the
 * {@link java.util.stream.IntStream} of prime numbers. That stream is used in all public methods on this class.
 * <p>
 * See {@link OOSumOfPrimes} for a reference
 * TODO: implement each method according to the javadoc and verify it by running {@link PrimeNumbersTest}
 * <p>
 * TODO: if you find this exercise valuable and you want to get more like it, <a href="https://www.patreon.com/bobocode">
 *     please support us on Patreon</a>
 *
 * @author Taras Boychuk
 */
public class PrimeNumbers {
    private PrimeNumbers() {
    }

    /**
     * Generates an infinite int stream of prime numbers.
     * The stream values are 2, 3, 5,... and so on.
     *
     * @return an infinite int stream of prime numbers
     */
    public static IntStream stream() {
        return IntStream.iterate(2, i -> i + 1)
                .filter(PrimeNumbers::isPrime);
        // todo: create an infinite stream of ints, then filter prime numbs
    }

    /**
     * Generates an int stream of a certain amount of prime numbers.
     * It is based on the {@link PrimeNumbers#stream()} but specifies the exact size of the stream.
     *
     * @return an int stream of prime numbers with a specified size
     */
    public static IntStream stream(int size) {
        return stream().limit(size);
        // todo: use the prev to generate a stream method but limit its size
    }

    /**
     * Calculates the sum on first n prime numbers.
     * E.g. if n = 5, the result should be 2 + 3 + 5 + 7 + 11 = 28
     *
     * @param n the number of first prime numbers
     * @return the sum of n prime numbers
     */
    public static int sum(int n) {
        return stream(n).sum();
        // todo: use prev method and calculate the sum
    }

    /**
     * Collects n first prime numbers.
     *
     * @return a list of collected prime numbers
     */
    public static List<Integer> list(int n) {
        return stream(n).boxed().collect(toList());
        // todo: collect prime numbers into the list
    }

    /**
     * Find a prime number by index and then applies a provided consumer passing found prime number
     *
     * @param idx      the position of a prime number (index), starting from 0
     * @param consumer a logic that should be applied to the found prime number
     */
    public static void processByIndex(int idx, IntConsumer consumer) {
        stream().skip(idx).findFirst().ifPresent(consumer);
        // todo: find an element in the stream by index and process it
    }

    /**
     * Creates a list of n prime numbers and returns a map where all of those prime numbers are grouped. The key represents
     * an amount of digits and the value is a corresponding list of all prime numbers.
     * <p>
     * So if you will call this method for with argument 20, you will receive the following map:
     * {1=[2, 3, 5, 7], 2=[11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71]}
     *
     * @param n – the amount of prime numbers
     * @return a map with prime number grouped by the amount of digits
     */
    public static Map<Integer, List<Integer>> groupByAmountOfDigits(int n) {
        return stream(n)
                .boxed()
                .collect(groupingBy(num -> String.valueOf(num).length()));
        // todo: group n prime numbers by the amount of digits
    }

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}