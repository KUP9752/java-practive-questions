package StreamReduction68e6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Example {

    static List<Integer> concatenate(List<List<Integer>> lists) {
        List<Integer> identity = new ArrayList<>();
        return lists.stream().reduce(identity, (a, b) -> {
            a.addAll(b);
            return a;
        });
    }

    static int findMin(List<Integer> ints) {
//        return ints.stream().reduce(Integer.MAX_VALUE, (a, b) -> {
//            return a < b ? a : b;
//        });
        return ints.stream().reduce(Integer.MAX_VALUE, Integer::min);
    }

    static int findMax(List<Integer> ints) {
        return ints.stream().reduce(Integer.MIN_VALUE, (a, b) -> (a > b) ? a : b);
    }

    static int findMinOrZero(List<Integer> ints) {
        return ints.stream().reduce(Integer::min)
                .orElse(0);
    }

    static int findMaxOrZero(List<Integer> ints) {
//        return ints.stream().reduce(Integer::max)
//                .orElse(0);
        return ints.stream().reduce((a, b) -> (a > b) ? a : b)
                .orElse(0);
    }

    static int findMinOfMaxes(List<List<Integer>> lists) {
        return findMin(lists.stream().map(Example::findMax).toList());
    }

    public static void Demo() {
        final List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 9);
        final List<Integer> list2 = Arrays.asList(1, 10, 100, 1000, 10000);
        final List<Integer> list3 = Arrays.asList(6, 7, 8);
        final List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        final List<Integer> allIntegers = concatenate(listOfLists);
        final int maxList1 = findMax(list1);
        final int minList2 = findMin(list2);
        final int maxEmpty = findMax(Collections.emptyList());
        final int minEmpty = findMin(Collections.emptyList());
        final int maxOrZeroEmpty = findMinOrZero(Collections.emptyList());
        final int minOrZeroEmpty = findMaxOrZero(Collections.emptyList());
        final int minOfMaxes = findMinOfMaxes(listOfLists);
        final int minOfMaxesEmpty = findMinOfMaxes(Collections.emptyList());
        final int minOfMaxesListOfEmptyLists = findMinOfMaxes(Arrays.asList(Collections.emptyList(), Collections.emptyList()));
    }

    public static void main(String[] args) {
        final List<List<Integer>> listInts  = new ArrayList<>();
        final List<Integer> ints = List.of(1, 2, 3, 4);

        final List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 9);
        final List<Integer> list2 = Arrays.asList(1, 10, 100, 1000, 10000);
        final List<Integer> list3 = Arrays.asList(6, 7, 8);
        final List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        listInts.add(ints);
        listInts.add(ints);
        listInts.add(ints);
        listInts.add(ints);


        System.out.println(concatenate(listInts));
        System.out.println(concatenate(new ArrayList<>()));
        System.out.println(findMin(ints));

        System.out.println(findMin(new ArrayList<>()));

        System.out.println(findMinOrZero(ints));
        System.out.println(findMinOrZero(new ArrayList<>()));

        System.out.println(findMaxOrZero(ints));
        System.out.println(findMaxOrZero(new ArrayList<>()));

        System.out.println(findMinOfMaxes(listOfLists));
    }
}
