import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbers014e {
    public static List<Integer> genRandom(int x) {
        Random rand = new Random();
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

    public static void main(String[] args) {
//        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4));
//        System.out.println(set);
//        set.removeIf(Predicate.isEqual(1));
//        System.out.println(set);

        System.out.println(genRandom(4));
    }
}
