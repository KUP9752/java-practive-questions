package GenericStacks2ffc;

import java.util.Stack;

public class GenericStackArray<T> implements GenericStack<T>{
    final T[] stack;
    private static final int STACK_SIZE = 100;
    private int nextFree;

    @SuppressWarnings("unchecked")
    public GenericStackArray() {
        this.stack =  (T[]) new Object[STACK_SIZE];
        this.nextFree = 0;
    }

    private boolean isFull() {
        return nextFree == STACK_SIZE;
    }

    @Override
    public void push(T item) {
        if (!isFull()) {
            stack[nextFree] = item;
            nextFree++;
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        nextFree--;
        return stack[nextFree];
    }

    @Override
    public boolean isEmpty() {
        return nextFree == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("| ");
        int counter = nextFree - 1;
        while (counter >= 0) {
            sb.append(stack[counter])
                    .append(" | ");
            counter--;
        }
        return sb.toString();
    }

}
