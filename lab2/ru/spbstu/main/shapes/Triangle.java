package ru.spbstu.main.shapes;

import static java.lang.Math.cos;

public class Triangle implements Polygon {

    private Point point1;
    private Point point2;
    private Point point3;

    private int angle;
    private Point center;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        setCenter();
        if (getArea() == 0) {
            throw new IllegalArgumentException("Points must be different and mustn't be on the same line in"
                + typeOfShape());
        }
    }

    @Override
    public String typeOfShape() {
        return ("Triangle");
    }

    @Override
    public float getArea() {
        return Math.abs((point1.getX() - point3.getX()) * (point2.getY() - point3.getY())
            - (point2.getX() - point3.getX()) * (point1.getY() - point3.getY())) / 2;
    }

    @Override
    public void rotate(int angle) {
        int newAngle = this.angle + angle;
        var angleInRads = Math.toRadians(newAngle);

        float x1 = (float) (center.getX() + (point1.getX() - center.getX())
            * cos(angleInRads) - (point1.getY() - center.getY()) * Math.sin(angleInRads));
        float y1 = (float) (center.getY() + (point1.getY() - center.getY())
            * cos(angleInRads) + (point1.getX() - center.getX()) * Math.sin(angleInRads));

        float x2 = (float) (center.getX() + (point2.getX() - center.getX())
            * cos(angleInRads) - (point2.getY() - center.getY()) * Math.sin(angleInRads));
        float y2 = (float) (center.getY() + (point2.getY() - center.getY())
            * cos(angleInRads) + (point2.getX() - center.getX()) * Math.sin(angleInRads));

        float x3 = (float) (center.getX() + (point3.getX() - center.getX())
            * cos(angleInRads) - (point3.getY() - center.getY()) * Math.sin(angleInRads));
        float y3 = (float) (center.getY() + (point3.getY() - center.getY())
            * cos(angleInRads) + (point3.getX() - center.getX()) * Math.sin(angleInRads));

        point1 = new Point2D(x1, y1);
        point2 = new Point2D(x2, y2);
        point3 = new Point2D(x3, y3);

        this.angle = newAngle;
    }

    @Override
    public float getRotation() {
        return angle;
    }

    @Override
    public float getPerimeter() {
        var p1 = (float) (Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2)
            + Math.pow(point1.getY() - point2.getY(), 2)));
        var p2 = (float) (Math.sqrt(Math.pow(point2.getX() - point3.getX(), 2)
            + Math.pow(point2.getY() - point3.getY(), 2)));
        var p3 = (float) (Math.sqrt(Math.pow(point3.getX() - point1.getX(), 2)
            + Math.pow(point3.getY() - point1.getY(), 2)));

        return p1 + p2 + p3;
    }

    private void setCenter() {
        this.center = new Point2D((point1.getX() + point2.getX() + point3.getX()) / 3,
            (point1.getY() + point2.getY() + point3.getY()) / 3);
    }

    public Point getCenter() {
        return center;
    }
}
