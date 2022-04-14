package RandomNumbers014e;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers {
    private static final Random rand = new Random();

    public static List<Integer> genRandomSet(int x) {
        Set<Integer> allNums = new HashSet<>();
        IntStream.range(0, x).forEach(allNums::add);
        List<Integer> genVals = new ArrayList<>();
        while (!allNums.isEmpty()) {
            int val = rand.ints(0, x).findFirst().getAsInt();
            genVals.add(val);
            allNums.removeIf(Predicate.isEqual(val));
        }
        return genVals;
    }

    public static List<Integer> genRandom(int x) {
        Map<Integer, Integer> allNums = new HashMap<>();
        List<Integer> genVals = new ArrayList<>();
        while (allNums.size() != x) {
            int val = rand.ints(0, x).findFirst().getAsInt();
            genVals.add(val);
            allNums.putIfAbsent(val, val);

        }

        return genVals;
    }

    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4));
//        System.out.println(set);
//        set.removeIf(Predicate.isEqual(1));
//        System.out.println(set);
        System.out.println(genRandomSet(4));
        System.out.println(genRandom(4));
    }
}