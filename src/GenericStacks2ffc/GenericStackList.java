package GenericStacks2ffc;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;

public class GenericStackList<T> implements GenericStack<T>{
    private final List<T> stack;

    public GenericStackList() {
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        stack.add(item);
    }

    @Override
    public T pop() {
        return isEmpty() ? null : stack.remove(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("| ");
        List<T> copyStack = new ArrayList<>(stack);
        reverse(copyStack);
        copyStack.forEach(
                item -> sb.append(item)
                        .append( " | ")
        );
        return sb.toString();
    }

}
