package ru.spbstu.main;

import ru.spbstu.main.shapes.*;

public class Main {

    public static Shape maxArea(Shape[] shapes) {
        float max = shapes[0].getArea();
        int index = 0;
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > max) {
                index = i;
                max = shapes[i].getArea();
            }
        }
        return shapes[index];
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];

        try {
            shapes[0] = new Circle(new Point2D(17.4f, 12.3f), 5);
            shapes[1] = new Circle(new Point2D(20, 10), 4);
            shapes[2] = new Circle(new Point2D(20, 10), 18);

            shapes[3] = new Rectangle(new Point2D(7.2f, 5.3f), new Point2D(2.5f, 1.1f));
            shapes[4] = new Rectangle(new Point2D(3, 4), new Point2D(5, 3));
            shapes[5] = new Rectangle(new Point2D(2, 1), new Point2D(4, 7));
            shapes[6] = new Rectangle(new Point2D(1, 9), new Point2D(9, 1));

            shapes[7] = new Triangle(new Point2D(5.7f, 7.3f), new Point2D(9.7f, 21.6f),
                new Point2D(12.1f, 8.9f));
            shapes[8] = new Triangle(new Point2D(1, 1), new Point2D(5, 10), new Point2D(10, 7));
            shapes[9] = new Triangle(new Point2D(5, 5), new Point2D(10, 8), new Point2D(15, 5));

            Shape maxAreaShape = maxArea(shapes);

            System.out.println("Shape with max area is " +
                maxAreaShape.typeOfShape() +
                ", area = " + maxAreaShape.getArea());

        } catch (RuntimeException e) {
            System.out.println(e);
            return;
        }
    }
}
