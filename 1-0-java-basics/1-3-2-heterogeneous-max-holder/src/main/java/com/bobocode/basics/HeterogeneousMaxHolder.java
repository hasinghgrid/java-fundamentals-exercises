package com.bobocode.basics;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link HeterogeneousMaxHolder} is a multi-type container that holds maximum values per each type. It's kind of a
 * key/value map, where the key is a type and the value is the maximum among all values of this type that were put.
 * <p>
 * It's based on the {@link Map} and provides an API that allows to put a value by type, and get a max value by type.
 * <p>
 * <p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com">visit our website</a></strong>
 * <p>
 *
 * @author Taras Boychuk
 */
public class HeterogeneousMaxHolder {
    private final Map<Class<?>, Object> maxValues = new HashMap<>();
    /**
     * A method put stores a provided value by its type, if the value is greater than the current maximum. In other words, the logic
     * of this method makes sure that only max value is stored and everything else is ignored.
     * <p>
     * If the current max value is less than a provided one, or if it's null, then a provided value gets stored and the old
     * max is returned. Otherwise, nothing new is added, and the provided value is returned.
     * <p>
     * So technically, this method always stores the greater value and returns the smaller one.
     *
     * @param key   a provided value type
     * @param value a value to put
     * @param <T>   value type parameter
     * @return a smaller value among the provided value and the current maximum
     */
    // todo: implement a method according to javadoc
    public <T extends Comparable<? super T>> T put(Class<T> key, T value) {
        // Get the current max for this type, safely cast it to T
        T currentMax = (T) maxValues.get(key); // Unchecked cast, but we handle this with null checks
        // If there is no current max or the provided value is greater, update the map
        if (currentMax == null || value.compareTo(currentMax) > 0) {
            maxValues.put(key, value);
            return currentMax;
        }
        // Return the smaller of the two values
        return value;
    }

    /**
     * An overloaded method put implements the same logic using a custom comparator. A given comparator is wrapped with
     * a null-safe comparator, considering null smaller than any non-null object.
     * <p>
     * All arguments must not be null.
     *
     * @param key        a provided value type
     * @param value      a value to put
     * @param comparator a custom comparator for the given type
     * @param <T>        value type parameter
     * @return a smaller value among the provided value and the current maximum
     */
    // todo: implement a method according to javadoc
    public <T> T put(Class<T> key, T value, Comparator<? super T> comparator) {
        // Get the current max value for this type
        T currentMax = (T) maxValues.get(key); // Unchecked cast, but we handle this with null checks
        // If there is no current max or the provided value is greater based on the comparator, update the map
        if (currentMax == null || comparator.compare(value, currentMax) > 0) {
            maxValues.put(key, value);
            return currentMax;
        }
        // Return the smaller of the two values based on the comparator
        return value;
    }

    /**
     * A method getMax returns a max value by the given type. If no value is stored by this type, then it returns null.
     *
     * @param key a provided value type
     * @param <T> value type parameter
     * @return current max value or null
     */
    // todo: implement a method according to javadoc
    public <T> T getMax(Class<T> key) {
        // Safely cast the object stored in the map to the appropriate type
        return key.cast(maxValues.get(key)); // Use Class.cast to avoid unchecked casts
    }
}