package WordCount67dd;

import java.util.Scanner;
import java.util.stream.Collectors;

public class WordCount {

    private static Scanner reader= new Scanner(System.in);
    private static int lines = 0;
    private static int words = 0;
    private static int chars = 0;

    public static String countWords() {
        StringBuilder sb = new StringBuilder();
        String line;
        int count = 0;

        while(reader.hasNextLine()) {
            line = reader.nextLine();
            System.out.println(line);
            chars += line.length();
            count++;
        }

        sb.append(chars);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countWords());
    }
}
