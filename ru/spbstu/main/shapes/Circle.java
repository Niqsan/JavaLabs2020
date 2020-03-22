package ru.spbstu.main.shapes;

public class Circle implements Ellipse {

    private Point center;
    private float radius;

    public Circle(Point center, float radius) {
        this.center = center;
        this.radius = radius;
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be > 0 in " + typeOfShape());
        }
    }

    @Override
    public String typeOfShape() {
        return ("Circle");
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * Math.pow(radius, 2));
    }

    @Override
    public float getLength() {
        return (float) (Math.PI * (2 * radius));
    }

    public Point getCenter() {
        return center;
    }

}
