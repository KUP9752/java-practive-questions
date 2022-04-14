package GenericNumberManip1aeb;

public interface NumberAdder<T extends Number> {

    T zero();

    public T add(T x, T y);
}
