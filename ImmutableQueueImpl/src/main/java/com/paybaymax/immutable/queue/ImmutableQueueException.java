package com.paybaymax.immutable.queue;

/**
 * Created by Ram on 30-Dec-19.
 */
public class ImmutableQueueException extends Exception {

    public ImmutableQueueException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImmutableQueueException(String message) {
        super(message);
    }
}
