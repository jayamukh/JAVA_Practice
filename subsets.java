/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Scanner;

public class subsets {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }

        int total = (int) Math.pow(2, n);

        for (int i = 0; i < total; i++) {
            int num = i;
            String str = "";
            for (int j = n - 1; j >= 0; j--) {
                int rem = num % 2;
                num = num / 2;
                if (rem == 1) {
                    str = a[j] + "\t" + str;
                }
                else {
                    str = "-\t" + str;
                }
            }

            System.out.println(str);
        }

    }

}
