package GenericSetsb401;

public interface GenericSet<T> {

    public void add(T item);

    public boolean remove(T item);

    public boolean isEmpty();

    public boolean contains(T item);
}
