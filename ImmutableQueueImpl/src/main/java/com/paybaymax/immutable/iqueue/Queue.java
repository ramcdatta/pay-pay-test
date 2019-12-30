package com.paybaymax.immutable.iqueue;


public interface Queue <T> {
    public Queue<T> enQueue(T t);
    /*#Removes the element at the beginning of the immutable iqueue, and returns the new iqueue.*/
    public Queue<T> deQueue();
    public T head();
    public boolean isEmpty();
}

