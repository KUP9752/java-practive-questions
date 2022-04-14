package GenericNumberManip1aeb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberManipulation {

    public static <T extends Number> Set<T> readNumbers(int n, NumberParser<T> parser){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Set<T> parsedNumbers = new HashSet<>();
        IntStream.range(0,n).forEach(
                i -> {
                    System.out.println("Please Enter a Number of type " + parser.typeParsed());
                    try {
                        parsedNumbers.add(parser.parseNumber(reader.readLine()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    return parsedNumbers;
    }

    public static <T extends Number> T addNumbers(Set<T> numbers, NumberAdder<T> adder) {
        return numbers.stream().reduce(adder.zero(), adder::add);
    }

    public static <T extends Number> Set<Double> displayAsDoubles(Set<T> numbers) {
        return numbers.stream().map(Number::doubleValue).collect(Collectors.toSet());
    }

    public static <T extends Number> Set<Integer> displayAsIntegers(Set<T> numbers) {
        return numbers.stream().map(Number::intValue).collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        Set<Integer> ints = readNumbers(3, new IntegerParser());
        Set<Double> ds = readNumbers(3, new DoubleParser());
        System.out.println(addNumbers(ints, new IntegerAdder()));
        System.out.println(addNumbers(ds, new DoubleAdder()));

        System.out.println(displayAsDoubles(ints));
        System.out.println(displayAsIntegers(ds));


    }
}
