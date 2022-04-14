package ReusingImmutableValueObjs1ae9;

import java.lang.ref.WeakReference;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Point {
    private final int coordX;
    private final int coordY;
    private final int coordZ;
    private static final WeakHashMap<Point, WeakReference<Point>> pool = new WeakHashMap<>();

    //called a factory method
    public static Point makePoint(int x, int y, int z) {
        Point newPoint = new Point(x, y, z);
        if (pool.containsKey(newPoint)) return pool.get(newPoint).get();
        pool.put(newPoint, new WeakReference<>(newPoint));
        return newPoint;
    }

    public static int getPoolSize() {
        return pool.size();
    }

    public Point(int coordX, int coordY, int coordZ) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.coordZ = coordZ;
    }

    @Override
    public String toString() {
        return "(" + coordX + ", " + coordY + ", " + coordZ + ")";
    }

    @Override
    public boolean equals(Object that) {
        return that instanceof Point
                && coordX == ((Point) that).coordX
                && coordY == ((Point) that).coordY
                && coordZ == ((Point) that).coordZ;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(coordX).hashCode()
                ^ Integer.valueOf(coordY).hashCode()
                ^ Integer.valueOf(coordZ).hashCode();
    }

    public static void main(String[] args) {
        List<Point> diffPoints = new ArrayList<>();
        List<Point> samePoints = new ArrayList<>();
        IntStream.range(0, 10).forEach(
                n -> {
                    diffPoints.add(new Point(1, 1, 1));
                    samePoints.add(Point.makePoint(1, 1, 1));
                }
        );
        System.out.println(diffPoints.stream().map(System::identityHashCode).toList());
        System.out.println(samePoints.stream().map(System::identityHashCode).toList());
    }
}
