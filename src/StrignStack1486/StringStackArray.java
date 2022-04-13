package StrignStack1486;

import java.util.ArrayList;
import java.util.List;

public class StringStackArray implements StringStack{
    private final String[] stack;
    private int nextFree;

    public StringStackArray() {
        this.stack = new String[100];
        this.nextFree = 0;

    }
    private boolean isFull() {
        return nextFree == 100;
    }

    @Override
    public void push(String s) {
        if (!isFull()) {
            stack[nextFree] = s;
            nextFree++;
        }
    }

    @Override
    public String pop() {
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
