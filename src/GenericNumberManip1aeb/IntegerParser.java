package GenericNumberManip1aeb;

public class IntegerParser implements NumberParser<Integer>{
    @Override
    public Integer parseNumber(String s) {
        return Integer.valueOf(s);
    }

    @Override
    public String typeParsed() {
        return "Integer";
    }
}

