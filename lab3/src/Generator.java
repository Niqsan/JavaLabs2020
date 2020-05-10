import java.util.concurrent.BlockingDeque;

public class Generator extends Thread {

    public Generator(BlockingDeque<Student> students, int iterations) {
        this.students = students;
        this.iterations = iterations;
    }

    public BlockingDeque<Student> students;
    final private int iterations;

    @Override
    public void run() {

        try {
            for (int i = 0; i < iterations; ++i) {
                generateStudent();
            }
            students.put(new Student("finish", 0));
        } catch (InterruptedException | IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void generateStudent() {
        int labsCountRnd = (int) (Math.random() * 3);
        int subjectRnd = (int) (Math.random() * 3);
        int labsCount;
        String subject;
        switch (labsCountRnd) {
            case 1:
                labsCount = 10;
                break;
            case 2:
                labsCount = 20;
                break;
            default:
                labsCount = 100;
        }

        switch (subjectRnd) {
            case 0:
                subject = "Math";
                break;
            case 1:
                subject = "OOP";
                break;
            case 2:
                subject = "Physics";
                break;
            default:
                subject = "HigherMath";
        }
        try {
            students.put(new Student(subject, labsCount));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
