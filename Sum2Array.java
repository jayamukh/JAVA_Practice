/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  xxxxx
 *  Last modified:     Dec 29, 2021
 **************************************************************************** */

import java.util.Scanner;

public class Sum2Array {
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

        int sum[] = sumOf2Array(a1, a2);

        for (int i = 0; i < sum.length; i++) {
            System.out.println(sum[i]);
        }

    }

    public static int[] sumOf2Array(int a1[], int a2[]) {
        int[] sum = new int[(a1.length > a2.length) ? (a1.length + 1) : (a2.length + 1)];


        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = sum.length - 1;
        int c = 0;

        while (k >= 0) {
            if ((i >= 0) && (j >= 0)) {
                sum[k] = ((a1[i] + a2[j] + c) % 10);
                c = (a1[i] + a2[j] + c) / 10;
                i--;
                j--;
                k--;
            }
            else if ((i >= 0) && (j < 0)) {
                sum[k] = (c + a1[i]) % 10;
                c = (c + a1[i]) / 10;
                i--;
                k--;
            }
            else if ((i < 0) && (j >= 0)) {
                sum[k] = (c + a2[j]) % 10;
                c = (c + a2[j]) / 10;
                j--;
                k--;
            }
            else {
                sum[k] = c % 10;
                c = c / 10;
                k--;
            }
        }

        return sum;
    }
}
