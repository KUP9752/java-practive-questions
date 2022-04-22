package LotteryNumbers4c70;

import java.util.*;
import java.util.stream.IntStream;

public class LottoGen {

    private static final Random random = new Random();
    private static final Set<Integer> ints = new HashSet<>(IntStream.range(1, 50).boxed().toList());

    private static int getNumber() {
        int num;
        do {
            num = random.nextInt(1, 50);

        } while (!ints.contains(num));
        ints.remove(num);
        return num;
    }

    public static String generate() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(1, 7).forEach(
                i -> {
                    sb.append("Number ").append(i).append(": ")
                            .append(getNumber()).append('\n');
                }
        );
        sb.append("Bonus Number: ").append(getNumber());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(generate());
        System.out.println(ints);
    }
}
