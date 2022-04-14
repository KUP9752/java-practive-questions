package GenericNumberManip1aeb;

public interface NumberParser<E extends Number> {

    // Convert string to number
    public E parseNumber(String s);

    // return the type of E
    public String typeParsed();
}
