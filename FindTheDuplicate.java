/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Scanner;

public class FindTheDuplicate {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }

        boolean[] count = new boolean[n + 1];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = a[i];
            if (!count[a[i]]) {
                count[a[i]] = true;
            }
            else {
                System.out.println("Duplicate no is:" + temp);
            }
        }

        for (int i = 1; i <= n; i++) {

            if (!count[i]) {
                System.out.println("Missing no is:" + i);
            }
        }

    }
}
