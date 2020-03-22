package ru.spbstu.main.shapes;

public class ShapesExepction extends RuntimeException {
    public ShapesExepction(String message) {
        super(message);
    }

    public ShapesExepction(String message, Throwable cause) {
        super(message, cause);
    }
}
