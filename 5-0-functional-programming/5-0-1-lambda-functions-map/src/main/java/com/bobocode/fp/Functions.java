package com.bobocode.fp;

/**
 * An util class that provides a factory method for creating an instance of a {@link FunctionMap} filled with a list
 * of functions.
 * <p>
 * TODO: implement a method and verify it by running {@link FunctionsTest}
 * <p>
 * TODO: if you find this exercise valuable and you want to get more like it, <a href="https://www.patreon.com/bobocode">
 *     please support us on Patreon</a>
 *
 * @author Taras Boychuk
 */
public class Functions {
    private Functions() {
    }

    /**
     * A static factory method that creates an integer function map with basic functions:
     * - abs (absolute value)
     * - sgn (signum function)
     * - increment
     * - decrement
     * - square
     *
     * @return an instance of {@link FunctionMap} that contains all listed functions
     */
    public static FunctionMap<Integer, Integer> intFunctionMap() {
        FunctionMap<Integer, Integer> intFunctionMap = new FunctionMap<>();

        // todo: according to the javadoc add functions using lambda expression
        // Adding absolute value function
        intFunctionMap.addFunction("abs", x -> Math.abs(x));

        // Adding signum function (returns -1 for negative, 0 for zero, 1 for positive)
        intFunctionMap.addFunction("sgn", x -> Integer.compare(x, 0));

        // Adding increment function (adds 1)
        intFunctionMap.addFunction("increment", x -> x + 1);

        // Adding decrement function (subtracts 1)
        intFunctionMap.addFunction("decrement", x -> x - 1);

        // Adding square function (multiplies number by itself)
        intFunctionMap.addFunction("square", x -> x * x);

        return intFunctionMap;
    }
}
