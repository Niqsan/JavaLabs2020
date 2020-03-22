package ru.spbstu.main.shapes;

public class Rectangle implements Polygon {

    private Point point1;
    private Point point2;
    private Point center;
    private int angle;

    public Rectangle(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
        setCenter();
        if (getArea() == 0) {
            throw new IllegalArgumentException("Points must be different and mustn't be on the same line in "
                + typeOfShape());
        }
    }

    @Override
    public String typeOfShape() {
        return ("Rectangle");
    }

    @Override
    public float getArea() {
        return Math.abs((point1.getX() - point2.getX())
            * (point1.getY() - point2.getY()));
    }

    @Override
    public void rotate(int angle) {
        int newAngle = this.angle + angle;
        var angleInRads = Math.toRadians(newAngle);

        float x1 =
            (float) (center.getX() + (point1.getX() - center.getX()) * Math.cos(angleInRads) - (point1.getY()
                - center.getY()) * Math.sin(angleInRads));
        float y1 =
            (float) (center.getY() + (point1.getY() - center.getY()) * Math.cos(angleInRads) + (point1.getX()
                - center.getX()) * Math.sin(angleInRads));
        float x2 =
            (float) (center.getX() + (point2.getX() - center.getX()) * Math.cos(angleInRads) - (point2.getY()
                - center.getY()) * Math.sin(angleInRads));
        float y2 =
            (float) (center.getY() + (point2.getY() - center.getY()) * Math.cos(angleInRads) + (point2.getX()
                - center.getX()) * Math.sin(angleInRads));

        point1 = new Point2D(x1, y1);
        point2 = new Point2D(x2, y2);

        this.angle = newAngle;
    }

    @Override
    public float getRotation() {
        return angle;
    }

    @Override
    public float getPerimeter() {
        return 2 * (Math.abs(point1.getX() - point2.getX()) + Math.abs(point1.getY() - point2.getY()));
    }

    public Point getCenter() {
        return center;
    }

    private void setCenter() {
        float centerX;
        float maxX = Math.max(point1.getX(), point2.getX());
        float minX = Math.min(point1.getX(), point2.getX());
        if (maxX > 0) {
            if (minX > 0) {
                centerX = minX + (maxX - minX) / 2;
            } else {
                centerX = minX + (Math.abs(minX) + maxX) / 2;
            }
        } else {
            centerX = maxX - (Math.abs(minX) - Math.abs(maxX)) / 2;
        }

        float centerY;
        float maxY = Math.max(point1.getY(), point2.getY());
        float minY = Math.min(point1.getY(), point2.getY());
        if (maxY > 0) {
            if (minY > 0) {
                centerY = minY + (maxY - minY) / 2;
            } else {
                centerY = minY + (Math.abs(minY) + maxY) / 2;
            }
        } else {
            centerY = maxY - (Math.abs(minY) - Math.abs(maxY)) / 2;
        }
        center = new Point2D(centerX, centerY);
    }
}
