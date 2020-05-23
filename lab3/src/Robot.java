import java.util.concurrent.BlockingQueue;

public class Robot implements Runnable {

    private final String subject;
    public BlockingQueue<Student> queue;

    public Robot(BlockingQueue<Student> students, String subject) {
        this.queue = students;
        this.subject = subject;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Student student = queue.take();
                if ((student.getLabsCount() != 0) ) {
                    if (student.getSubject().equals(subject)) {
                        student = queue.take();
                        handle(student);
                    }
                } else {
                    queue.put(new Student(-1, "Generator finished", 0));
                    System.out.println("Robot" + subject + " ended");
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void handle(Student student) throws InterruptedException {
        System.out.println("Student " + student.getId() +
                " enters the" +
                student.getSubject() +
                " class with " +
                student.getLabsCount() + " " +
                student.getSubject() +
                " labs");

        for (int i = 0; i < student.getLabsCount() / 5; i++) {
            System.out.println("Student " +
                    student.getId() +
                    " passed 5 laboratory works");
        }
        System.out.println("Student " + student.getId() + " done");
    }
}
