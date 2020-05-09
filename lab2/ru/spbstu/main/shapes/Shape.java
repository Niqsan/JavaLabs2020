package ru.spbstu.main.shapes;

public interface Shape {

    String typeOfShape();

    float getArea();

    Point getCenter();

    default void rotate(int angle) {
    };

    default float getRotation() {
        return 0;
    }
}
