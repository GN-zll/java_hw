package Homework2;

public final class point {
    private double x;
    private double y;

    public point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }
    public point() {
        this.x = 0;
        this.y = 0;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void translate(double new_x, double new_y) {
        x = new_x;
        y = new_y;
    }

    void scale(double a) {
        x = x*a;
        y = y*a;
    }

}
