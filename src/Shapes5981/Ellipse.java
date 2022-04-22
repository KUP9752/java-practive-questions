package Shapes5981;

public class Ellipse extends Shape{
    private double major;
    private double minor;

    public Ellipse(double major, double minor) {
        this.major = major;
        this.minor = minor;

    }

    @Override
    double size() {
        return Math.PI * major * minor;
    }

}
