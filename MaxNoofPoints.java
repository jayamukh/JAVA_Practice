/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Last modified:     May 27, 2022
 **************************************************************************** */

import java.util.Scanner;

public class MaxNoofPoints {
    public static long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long max_ponts = 0;
        for (int l = 0; l < n; l++) {
            max_ponts = Math.max(max_ponts, rec(points, m, n, 0, l));
        }
        return max_ponts;
    }

    public static long rec(int[][] points, int m, int n, int i, int j) {
        if (i == m - 1) {
            return points[i][j];
        }
        long max = 0;
        for (int k = 0; k < n; k++) {
            max = Math.max(max, rec(points, m, n, i + 1, k) - Math.abs(j - k));
        }
        return max;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();

        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        System.out.println(maxPoints(arr));
    }
}
