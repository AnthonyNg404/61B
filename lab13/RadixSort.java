
/**.
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**.
     */

    private static final int RADIX = 256;
    /**.
     * Does LSD radix sort on the passed
     * in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length
     * (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        if (asciis.length == 0) {
            return asciis;
        }

        int maxLength = 0;
        for (String s: asciis) {
            maxLength = Math.max(maxLength, s.length());
        }

        String[] sorted = asciis.clone();
        for (int i = maxLength - 1; i >= 0; i--) {
            sortHelperLSD(sorted, i);
        }
        return sorted;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        int[] count = new int[RADIX];
        for (String s: asciis) {
            if (s.length() < index + 1) {
                count[0] += 1;
            } else {
                int pos = s.charAt(index);
                count[pos] += 1;
            }
        }

        int[] start = new int[RADIX];
        int pos = 0;
        for (int i = 0; i < start.length; i++) {
            start[i] = pos;
            pos += count[i];
        }

        String[] arrayBackup = asciis.clone();
        for (String s: arrayBackup) {
            int item = 0;
            if (s.length() >= index + 1) {
                item = s.charAt(index);
            }
            int place = start[item];
            asciis[place] = s;
            start[item] += 1;
        }
    }

    /**
     * MSD radix sort helper function that recursively
     * calls itself to achieve the sorted array.
     * Destructive method that changes the passed
     * in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting
     *              in this method (includes String at start)
     * @param end int for where to end sorting
     *            in this method (does not include String at end)
     * @param index the index of the character
     *              the method is currently sorting on
     *
     **/
    private static void
        sortHelperMSD(String[] asciis, int start, int end, int index) {
        return;
    }
}
