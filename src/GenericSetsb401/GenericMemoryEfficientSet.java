package GenericSetsb401;

public class GenericMemoryEfficientSet<T> implements GenericSet<T> {
    @Override
    public void add(T item) {

    }

    @Override
    public boolean remove(T item) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T item) {
        return false;
    }
    
    @Override
    public String toString() {
        return "";
    }
}
