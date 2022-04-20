package IntSet8a61;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static IntSet readIntegers(int n) throws IOException {

        return n > 10 ? new MemoryEfficientIntSet() : new SpeedEfficientIntSet();
    }

    public static void main(String[] args) {
        int n = 1;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter an int");
            String line = reader.readLine();
            IntSet set = readIntegers(n);
            while (!line.equals("end of input")) {
                int inputNumber = Integer.parseInt(line);
                set.add(inputNumber);
                System.out.println("Please enter an int");
                line = reader.readLine();
            }
            System.out.println(set);
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }
}
