public class hw0 {
    public static void windowPosSum(int[] a, int n) {
        for (int i = 0; i < a.length; i += 1) {
            if (a[i] < 0) {
                continue;
            }
            for (int j = n, k = i + 1; j > 0; j -= 1, k += 1) {
                if (k >= a.length) {
                    break;
                }
                a[i] += a[k];
            }
        }
    }
     public static void main(String[] args) {
            int[] a = {1, -1, -1, 10, 5, -1};
            int n = 2;
            windowPosSum(a, n);

            // Should print 4, 8, -3, 13, 9, 4
            System.out.println(java.util.Arrays.toString(a));
        }
}


/**    public static void drawTriangle(int N) {
        int start = 1;
        int count = 0;
        while (start < N + 1) {
            while (count < start){
                System.out.print("*");
                count = count + 1;
            }
            start = start + 1;
            count = 0;
            if (start < N + 1) {
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        drawTriangle(10);

    }
 */

/**    public static int max(int[] m) {
 int count = 0;
 int maxFornow = m[0];
 while (count < m.length){
 if (maxFornow < m[count]){
 maxFornow = m[count];
 }
 count = count + 1;
 }
 return maxFornow;
 }
 public static void main(String[] args) {
 int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6, 67, 69};
 System.out.println(max(numbers));
 }
 */

/**public static int max(int[] m) {
    int theMax = 0;
    for (int count = 0, maxFornow = m[0]; count < m.length; count += 1) {
        if (maxFornow < m[count]) {
            maxFornow = m[count];
        }
        theMax = maxFornow;
    }
    return theMax;
}
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6, 67, 69};
        System.out.println(max(numbers));
    }
 */