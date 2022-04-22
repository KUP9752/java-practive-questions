package GenericStacks2ffc;

public interface GenericStack<T> {

    public void push(T item) throws StackFullException;

    public T pop() throws EmptyStackException;

    public boolean isEmpty();
}
