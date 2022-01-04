/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Scanner;

public class sub2Arr {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1, a2;

        a1 = new int[n1];


        for (int i = 0; i < n1; i++) {
            a1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        a2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            a2[i] = scn.nextInt();
        }

        int sub[] = DiffOf2Array(a1, a2);

        for (int i = 0; i < sub.length; i++) {
            if (!((i == 0) && (sub[i] == 0)))
                System.out.println(sub[i]);
        }

    }

    public static int[] DiffOf2Array(int a1[], int a2[]) {
        int[] sub = new int[Math.max(a1.length, a2.length)];


        int i = a2.length - 1;
        int j = a1.length - 1;
        int k = sub.length - 1;
        int b = 0, diff = 0;

        while (k >= 0) {
            if ((i >= 0) && (j >= 0)) {
                diff = a2[i] - b - a1[j];
                if (diff < 0) {
                    diff += 10;
                    b = 1;

                }
                else {
                    b = 0;
                }
                sub[k] = diff;
                i--;
                j--;
                k--;
            }
            else if ((i >= 0) && (j < 0)) {
                diff = a2[i] - b;
                if (diff < 0) {
                    diff += 10;
                    b = 1;
                }
                else {
                    b = 0;
                }
                sub[k] = diff;

                i--;
                k--;
            }
        }

        return sub;
    }


}
