import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testAddFirst() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        for (int i = 0; i < 10000; i++) {
            sad1.addFirst(i);
            ads1.addFirst(i);
            assertEquals(ads1.get(0), sad1.get(0));
        }
    }

    @Test
    public void testAddLast() {
        StudentArrayDeque<Integer> sad2 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads2 = new ArrayDequeSolution<>();
        for (int i = 0; i < 10000; i++) {
            sad2.addLast(i);
            ads2.addLast(i);
            assertEquals(ads2.get(ads2.size() - 1), sad2.get(sad2.size() - 1));
        }
    }

    @Test
    public void testSize() {
        StudentArrayDeque<Integer> sad3 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads3 = new ArrayDequeSolution<>();
        for (int i = 0; i < 10000; i++) {
            double random = StdRandom.uniform();
            if (random < 0.5) {
                sad3.addLast(i);
                ads3.addLast(i);
                assertEquals(ads3.size(), sad3.size());
            } else {
                sad3.addFirst(i);
                ads3.addFirst(i);
                assertEquals(ads3.size(), sad3.size());
            }
        }
    }

    @Test
    public void testRemoveFirst() {
        StudentArrayDeque<Integer> sad4 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads4 = new ArrayDequeSolution<>();
        for (int j = 1; j < 10; j++) {
            sad4.addFirst(j);
            ads4.addFirst(j);
        }
        for (int i = 1; i < 10; i++) {
            assertEquals(ads4.removeFirst(), sad4.removeFirst());
        }
    }


    @Test
    public void testRemoveLast() {
        StudentArrayDeque<Integer> sad5 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads5 = new ArrayDequeSolution<>();
        String message = "\n";
        for (int j = 1; j < 10; j++) {
            sad5.addLast(j);
            ads5.addLast(j);
            message += "addLast(" + j + ")" + "\n";
        }
        for (int i = 1; i < 10; i++) {
            message += "removeLast()" + "\n";
            assertEquals(message, ads5.removeLast(), sad5.removeLast());
        }
    }

    @Test
    public void testRandom() {
        StudentArrayDeque<Integer> sad6 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads6 = new ArrayDequeSolution<>();
        for (int j = 1; j < 100; j++) {
            String message = "\n";
            double random = StdRandom.uniform();
            int add = StdRandom.uniform(1000);
            if (random < 0.5) {
                sad6.addLast(add);
                ads6.addLast(add);
                message += "addLast(" + add + ")" + "\n";
                message += "removeLast()" + "\n";
                assertEquals(message, ads6.removeLast(), sad6.removeLast());
            } else {
                sad6.addFirst(add);
                ads6.addFirst(add);
                message += "addFirst(" + add + ")" + "\n";
                message += "removeFirst()" + "\n";
                assertEquals(message, ads6.removeFirst(), sad6.removeFirst());
            }
        }
    }
}
