import java.util.concurrent.BlockingDeque;

public class Robot extends Thread {

    private final String subject;
    public BlockingDeque<Student> students;

    public Robot(BlockingDeque<Student> students, String subject) {
        this.students = students;
        this.subject = subject;
        currentThread().setName(subject);

    }

    @Override
    public void run() {

        try {
            while (true) {
                Student student = students.peek();
                if (student != null && student.getSubject().equals(subject)) {
                    student = students.take();
                    System.out.println(subject + " teacher started verifying");
                    while (student.getLabsCount() != 0) {
                        System.out.println("Robot " + subject + " is working, " + student.getLabsCount() + " left");
                        student.verifyLabs();
                        sleep(1000);
                    }
                    System.out.println(subject + " teacher finished verifying");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
