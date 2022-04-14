package ReversedOrderOfInput2d33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class ReverseInput {

    //readline throws IOException
    public static String reverseInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("| ");
        String line = reader.readLine();
        Deque<String> stack = new ArrayDeque<>();
        while(!line.equals("END")) {
            stack.push(line);
            line = reader.readLine();
        }
        for (String s : stack) { //will achieve the same thing as stack.pop
            sb.append(s).append( " | ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(reverseInput());
        } catch (IOException e ) {
            e.printStackTrace();
        }
    }
}
