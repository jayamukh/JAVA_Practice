/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  123456
 *  Last modified:     August 2, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ImprovedInsSort {

    public static <C extends Comparable<C>> void sort(C[] a) {
        int len = a.length;

        for (int i = 1; i < len; i++) {
            C min = a[i];
            int j = i;
            for (j = i; j > 0 && less(min, a[j - 1]); j--)
                a[j] = a[j - 1];
            a[j] = min;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int index = 1; index < a.length; index++)
            if (less(a[index], a[index - 1]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
