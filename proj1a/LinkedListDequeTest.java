
/** Performs some basic linked list tests. */

public class LinkedListDequeTest {

	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
		boolean passed = checkEmpty(true, lld1.isEmpty());
		lld1.addFirst("front");
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;
		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;
		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;
		System.out.println(lld1.get(5));
		System.out.println(lld1.getRecursive(5));
		System.out.println("Printing out deque: ");
		lld1.printDeque();
		printTestStatus(passed);
	}

	public static void addRemoveTest() {
		System.out.println("Running add/remove test.");
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		boolean passed = checkEmpty(true, lld1.isEmpty());
		lld1.addFirst(10);
		passed = checkEmpty(false, lld1.isEmpty()) && passed;
		lld1.removeFirst();
		passed = checkEmpty(true, lld1.isEmpty()) && passed;
		printTestStatus(passed);
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}
}
