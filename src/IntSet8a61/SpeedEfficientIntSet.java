package IntSet8a61;

import java.util.HashMap;
import java.util.Map;

public class SpeedEfficientIntSet implements IntSet{

    private final Map<Integer, Integer> items;

    public SpeedEfficientIntSet() {
        this.items = new HashMap<>();
    }


    @Override
    public void add(int x) {
        items.putIfAbsent(x, x);
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
        return items.containsKey(x);
    }
    @Override
    public String toString() {
        return items.values().toString();
    }
}
