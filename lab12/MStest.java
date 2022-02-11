import org.junit.Test;
import edu.princeton.cs.algs4.Queue;


public class MStest {

    @Test
    public void mergesort() {
        Queue<String> students = new Queue<String>();
        students.enqueue("Vanessa");
        students.enqueue("Ithan");
        students.enqueue("Jthan");
        students.enqueue("Ethan");
        students.enqueue("Fthan");
        students.enqueue("Gthan");
        students.enqueue("Hthan");
        students.enqueue("Alice");
        students.enqueue("Kthan");

        students = MergeSort.mergeSort(students);
        System.out.println(students);
    }
}
