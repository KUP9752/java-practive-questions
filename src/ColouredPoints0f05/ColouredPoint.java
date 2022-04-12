package ColouredPoints0f05;

public class ColouredPoint extends Point {

    final Colour colour;

    public ColouredPoint(double x, double y, double z, Colour colour) {
        super(x, y, z);
        this.colour = colour;
    }

    public ColouredPoint(Point p, Colour colour) {
        this(p.getX(), p.getY(), p.getZ(), colour);
    }

    @Override
    public String toString() {
        return colour + ":" + super.toString();
    }



} enum Colour {
    WHITE, YELLOW, ORANGE, RED, PINK, BLUE, PURPLE, GREEN, GREY, BROWN, BLACK;

}
