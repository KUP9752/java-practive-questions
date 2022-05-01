package ColouredPoints0f05;

public class ColouredPoint extends Point {

    private final Colour colour;

    public ColouredPoint(double x, double y, double z, Colour colour) {
        super(x, y, z);
        this.colour = colour;
    }

    public ColouredPoint(Point p, Colour colour) {
        this(p.getX(), p.getY(), p.getZ(), colour);
    }

    public Colour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour + ":" + super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode() * colour.ordinal();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ColouredPoint otherPoint) {
            return super.equals(other) &&
                    colour.equals(otherPoint.getColour());
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(Colour.RED.ordinal());
    }



} enum Colour {
    WHITE, YELLOW, ORANGE, RED, PINK, BLUE, PURPLE, GREEN, GREY, BROWN, BLACK;

}
