package com.paybaymax.immutable.istack;

/**
 * Created by Ram on 30-Dec-19.
 */
public class ImmutableStackException extends Exception {

    public ImmutableStackException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImmutableStackException(String message) {
        super(message);
    }
}
