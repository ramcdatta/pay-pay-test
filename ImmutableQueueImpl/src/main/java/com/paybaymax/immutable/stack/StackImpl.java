package com.paybaymax.immutable.stack;


public final class StackImpl<E> implements Stack<E>{
    private final E head;
    private final Stack<E> tail;

    private StackImpl(E head, Stack<E> tail){
        this.head = head;
        this.tail = tail;
    }

    public final Stack<E> push(E e){
        return new StackImpl<E>(e, this);
    }

    public final Stack<E> pop(){
        return tail;
    }

    public final E head(){
        return head;
    }

    public final boolean isEmpty(){
        return false;
    }

    public final static Stack getEmptyStack(){
        return EmptyStack.getInstance();
    }


    private static final class EmptyStack<E> implements Stack<E>{

        private final static EmptyStack emptyStack = new EmptyStack();

        public final static EmptyStack getInstance(){
            return emptyStack;
        }

        public final Stack<E> push(E e){
            return new StackImpl<E>(e, this);
        }

        public final Stack<E> pop() {
            try {
                throw new Exception("Pop operation can not perform in empty Stack.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public final E head() {
            try {
                throw new Exception("head is not therefor empty Stack.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        public final boolean isEmpty(){
            return true;
        }
        }


}

