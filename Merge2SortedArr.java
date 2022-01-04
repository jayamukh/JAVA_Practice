/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Scanner;

public class Merge2SortedArr {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int n1 = scn.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n1; i++) {
            b[i] = scn.nextInt();
        }

        int[] res = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length || j < b.length) {
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    res[k] = a[i++];
                }
                else {
                    res[k] = b[j++];
                }
            }
            else if (i < a.length) {
                res[k] = a[i++];
            }
            else {
                res[k] = b[j++];
            }
            k++;
        }
        for (int row = 0; row < res.length; row++) {
            System.out.print(res[row] + "\t");
        }

    }
}
