package StrignStack1486;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;

public class StringStackList implements StringStack{
    protected List<String> stack;

    public StringStackList() {
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(String s) {
        stack.add(s);
    }

    @Override
    public String pop() {
        return stack.remove(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        List<String> copyStack = new ArrayList<>(stack);
        reverse(copyStack);
        StringBuilder sb = new StringBuilder();
        sb.append("| ");
        copyStack.stream().forEach(
                item -> sb.append(item).
                        append(" | ")
        );
        return sb.toString();
    }
}
