package com.paybaymax.immutable.iqueue;


import com.paybaymax.immutable.istack.ImmutableStack;
import com.paybaymax.immutable.istack.ImmutableStackImpl;

public final class ImmutableQueue<T> implements Queue<T>{

    private final ImmutableStack<T> rear;
    private final ImmutableStack<T> front;

    private ImmutableQueue(ImmutableStack<T> front, ImmutableStack<T> rear)
    {
        this.front = front;
        this.rear = rear;
    }


    public final Queue<T> enQueue(T e){
        return new ImmutableQueue<T>(front, rear.push(e));
    }

    public final Queue<T> deQueue() {
        ImmutableStack<T> f = front.pop();
        if (!f.isEmpty()){
            return new ImmutableQueue<T>(f, rear);
        }
        else if (rear.isEmpty()){
            return ImmutableQueue.getEmptyQueue();
        }
        else {
            return new ImmutableQueue<T>(ImmutableQueue.reverseStack(rear), ImmutableStackImpl.getEmptyStack());
        }
    }

    public final T head() {
        return front.head();
    }

    public final boolean isEmpty(){
        return false;
    }

    public final static ImmutableStack reverseStack(ImmutableStack immutableStack)
    {
        ImmutableStack newImmutableStack = ImmutableStackImpl.getEmptyStack();
        while(!immutableStack.isEmpty()){
            newImmutableStack = newImmutableStack.push(immutableStack.head());
            immutableStack = immutableStack.pop();
        }

        return newImmutableStack;
    }

    public final static Queue getEmptyQueue(){
        return EmptyQueue.getInstance();
    }

    private static final class EmptyQueue<T> implements Queue<T>{


        private final static EmptyQueue emptyQueue = new EmptyQueue();

        public final static EmptyQueue getInstance(){
            return emptyQueue;
        }

        public final Queue<T> enQueue(T e){
            return new ImmutableQueue<T>(ImmutableStackImpl.getEmptyStack().push(e), ImmutableStackImpl.getEmptyStack());
        }

        public final Queue<T> deQueue() {
            try {
                throw new ImmutableQueueException("dequeue() operation can not perform in empty Queue.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }

        public final T head() {
            try {
                throw new ImmutableQueueException("head is not there for empty Queue.");
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
