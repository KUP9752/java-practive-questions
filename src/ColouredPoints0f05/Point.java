package ColouredPoints0f05;

public class Point {
    private final double x;
    private final double y;
    private final double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public static Point getOrigin() {
        return new Point(0,0,0);
    }

    public double distanceTo(Point other) {
        double dx = x - other.getX();
        double dy = y - other.getY();
        double dz = z - other.getZ();
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2));
    }

    public double getMagnitude() {
        return distanceTo(getOrigin());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(")
                .append(x)
                .append(", ")
                .append(y)
                .append(", ")
                .append(z)
                .append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Point otherPoint) {
            return x == otherPoint.getX() &&
                    y == otherPoint.getY() &&
                    z == otherPoint.getZ();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) ((x * y * z) % 101);
    }

    public static void main(String[] args) {
        Point p = new Point(3, 4, 0);
        Point p1 = new Point(3, 4, 4);
        Point q = new Point(3, 4, 0);
//        System.out.println(p.getMagnitude());
//        System.out.println(p.distanceTo(p1));
//        System.out.println(p);

        ColouredPoint cp = new ColouredPoint(p, Colour.RED);
        ColouredPoint cq = new ColouredPoint(q, Colour.RED);

//        System.out.println(cp);

        System.out.println("p == q: "  + p.equals(q));
        System.out.println("cp == cq: "  + cp.equals(cq));
        System.out.println("p == cp : " + p.equals(cp)); // true
        System.out.println("cp == p: " + cp.equals(p)); // false  --> .equals is not symmetric


    }
}
