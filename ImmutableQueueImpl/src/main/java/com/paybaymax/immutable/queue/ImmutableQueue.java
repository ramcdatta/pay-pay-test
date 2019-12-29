package com.paybaymax.immutable.queue;


import com.paybaymax.immutable.stack.StackImpl;
import com.paybaymax.immutable.stack.Stack;

public final class ImmutableQueue<T> implements Queue<T>{

    private final Stack<T> rear;
    private final Stack<T> front;

    private ImmutableQueue(Stack<T> front, Stack<T> rear)
    {
        this.front = front;
        this.rear = rear;
    }


    public final Queue<T> enQueue(T e){
        return new ImmutableQueue<T>(front, rear.push(e));
    }

    public final Queue<T> deQueue() {
        Stack<T> f = front.pop();
        if (!f.isEmpty()){
            return new ImmutableQueue<T>(f, rear);
        }
        else if (rear.isEmpty()){
            return ImmutableQueue.getEmptyQueue();
        }
        else {
            return new ImmutableQueue<T>(ImmutableQueue.reverseStack(rear), StackImpl.getEmptyStack());
        }
    }

    public final T head() {
        return front.head();
    }

    public final boolean isEmpty(){
        return false;
    }

    public final static Stack reverseStack(Stack stack)
    {
        Stack newStack = StackImpl.getEmptyStack();
        while(!stack.isEmpty()){
            newStack = newStack.push(stack.head());
            stack = stack.pop();
        }

        return newStack;
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
            return new ImmutableQueue<T>(StackImpl.getEmptyStack().push(e), StackImpl.getEmptyStack());
        }

        public final Queue<T> deQueue() {
            try {
                throw new Exception("dequeue() operation can not perform in empty Queue.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        public final T head() {
            try {
                throw new Exception("head is not there for empty Queue.");
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
