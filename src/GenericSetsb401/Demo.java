package GenericSetsb401;

import IntSet8a61.IntSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    public static GenericSet<Integer> readIntegers(int n) throws IOException {
        return n > 10
                ? new GenericMemoryEfficientSet<>()
                : new GenericSpeedEfficientSet<>();
    }

    public static void main(String[] args) {
        int n;
//        n = Integer.parseInt(args[0]);
        n = 1;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter an int");
            String line = reader.readLine();
            GenericSet<Integer> set = readIntegers(n);
            while (!line.equals("end of input")) {
                int inputNumber = Integer.parseInt(line);
                set.add(inputNumber);
                System.out.println("Please enter an int");
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
