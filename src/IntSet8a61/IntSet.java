package IntSet8a61;

public interface IntSet {
    public void add(int x);

    default void addAll(int[] items) {
        for (int item : items) {
            add(item);
        }
    }

    default IntSet asUnmodifiableSet() {
        return new IntSet() {

            @Override
            public void add(int x) {
                throw new UnsupportedOperationException("Attempted to add to unmodifiable Set");
            }

            @Override
            public boolean remove(int x) {
                throw new UnsupportedOperationException("Attempted to remove from unmodifiable Set");
            }

            @Override
            public boolean isEmpty() {
                return IntSet.this.isEmpty();
            }

            @Override
            public boolean contains(int x) {
                return IntSet.this.isEmpty();
            }
        };
    }

    public boolean remove(int x);

    public boolean isEmpty();

    public boolean contains(int x);

}
