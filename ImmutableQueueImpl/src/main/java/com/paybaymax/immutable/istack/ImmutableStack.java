package com.paybaymax.immutable.istack;


public interface ImmutableStack<E> {

    public ImmutableStack<E> push(E t);
    public ImmutableStack<E> pop() ;
    public E head() ;
    public boolean isEmpty();
}
