package Properties0c21;

public class House extends Property {
    final Type type;
    final int story;

    public House(Type type, int story) {
        this.type = type;
        this.story = story;
    }

    public boolean isTerraced() {
        return type.equals(Type.TERRACED);
    }


} enum Type {
    DETACHED, SEMIDETACHED, TERRACED;
}
