import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<Student>  queue = new LinkedBlockingQueue<>(10);

        new Thread(new Generator(queue)).start();
        new Thread(new Robot(queue, "HigherMath")).start();
        new Thread(new Robot(queue, "OOP")).start();
        new Thread(new Robot(queue, "Physics")).start();
    }
}