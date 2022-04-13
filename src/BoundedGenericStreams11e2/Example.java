package BoundedGenericStreams11e2;

import java.util.*;
import java.util.function.BinaryOperator;

public class Example<E extends Collection<E>> {

    public Optional<? extends E> getSmallestColection(Collection<? extends E> collections) {
        if (collections.isEmpty()) return Optional.empty();
        return collections.stream().reduce(BinaryOperator.minBy(Comparator.comparingInt(Collection::size)));

    }

    public static void main(String[] args) {
        final Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        final Set<Integer> s2 = new HashSet<>(Arrays.asList(1, 2));
        final Set<Integer> s3 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        final Set<Integer> s4 = new HashSet<>(Arrays.asList(3, 4));
        final List<Set<Integer>> listOfSetsOfIntegers = Arrays.asList(s1, s2, s3, s4);
        Example ex = new Example();
        System.out.println(ex.getSmallestColection(listOfSetsOfIntegers));

    }
}
