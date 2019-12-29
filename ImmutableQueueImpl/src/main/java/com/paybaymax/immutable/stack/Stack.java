package com.paybaymax.immutable.stack;


public interface Stack<E> {

    public Stack<E> push(E t);
    public Stack<E> pop() ;
    public E head() ;
    public boolean isEmpty();
}
