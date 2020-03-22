package ru.spbstu.main.shapes;

public class Point2D implements Point {

    private final float x;
    private final float y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
