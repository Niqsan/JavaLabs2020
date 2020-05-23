import java.util.concurrent.BlockingQueue;

public class Generator implements Runnable {
    private final BlockingQueue<Student> queue;

    public Generator(BlockingQueue<Student> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 104; ++i) {
                generateStudent(i);
            }
            queue.put(new Student(-1, "Generator finished", 0));
        } catch (InterruptedException | IllegalStateException e) {
            e.printStackTrace();
        }
    }

    public void generateStudent(int i) {
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
                subject = "HigherMath";
                break;
            case 1:
                subject = "OOP";
                break;
            case 2:
                subject = "Physics";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + subjectRnd);
        }

        try {
            Student student = new Student(i, subject, labsCount);
            System.out.println("Student " + student.getId() + " in queues");
            queue.put(student);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
