public class ArrayDequeTest {
    public static void main (String[] args) {
        ArrayDeque<Integer> s = new ArrayDeque<>();

        for (int i = 100; i > -1; i -= 1) {
            s.addLast(i);
            s.addFirst(i);
        }
        s.printDeque();
        System.out.println(s.get(90));

        for (int i = 100; i > -1; i -= 1) {
            s.removeFirst();
            s.removeLast();
        }
        s.printDeque();
        System.out.println(s.get(0));

        for (int i = 100; i > -1; i -= 1) {
            s.addLast(i);
            s.addFirst(i);
        }
        s.printDeque();
        System.out.println(s.get(90));
    }

}
