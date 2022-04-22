package IntSet8a61;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MemoryEfficientIntSet implements IntSet {

    private List<Integer> items;

    public MemoryEfficientIntSet() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(int x) {
        if (!contains(x)) items.add(x);
    }

    @Override
    public void addAll(int[] ints) {
        Set<Integer> setInts = new HashSet<Integer>(items);
        for (int i : ints) {
            if (!setInts.contains(i)) {
                add(i);
                setInts.add(i);
            }
        }

    }

    @Override
    public boolean remove(int x) {
        boolean contains = contains(x);
        if (contains) items.remove(x);
        return contains;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean contains(int x) {
        return items.contains(x);
    }

    @Override
    public String toString() {
        return items.toString();
    }
}