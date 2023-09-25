package Homework2;

public final class Point {
    final private double x;
    final private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Point translate(double new_x, double new_y) {
        return new Point(new_x, new_y);
    }

    public Point scale(double a) {
        return new Point(x * a, y * a);
    }

}
