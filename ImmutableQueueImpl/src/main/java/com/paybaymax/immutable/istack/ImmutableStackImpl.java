package com.paybaymax.immutable.istack;


public final class ImmutableStackImpl<E> implements ImmutableStack<E> {
    private final E head;
    private final ImmutableStack<E> tail;

    private ImmutableStackImpl(E head, ImmutableStack<E> tail){
        this.head = head;
        this.tail = tail;
    }

    public final ImmutableStack<E> push(E e){
        return new ImmutableStackImpl<E>(e, this);
    }

    public final ImmutableStack<E> pop(){
        return tail;
    }

    public final E head(){
        return head;
    }

    public final boolean isEmpty(){
        return false;
    }

    public final static ImmutableStack getEmptyStack(){
        return EmptyImmutableStack.getInstance();
    }


    private static final class EmptyImmutableStack<E> implements ImmutableStack<E> {

        private final static EmptyImmutableStack emptyStack = new EmptyImmutableStack();

        public final static EmptyImmutableStack getInstance(){
            return emptyStack;
        }

        public final ImmutableStack<E> push(E e){
            return new ImmutableStackImpl<E>(e, this);
        }

        public final ImmutableStack<E> pop() {
            try {
                throw new ImmutableStackException("Pop operation can not perform in empty ImmutableStack.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

        public final E head() {
            try {
                throw new ImmutableStackException("head is not there for empty ImmutableStack.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
        public final boolean isEmpty(){
            return true;
        }
        }


}

