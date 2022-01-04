/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Scanner;

public class ExitPoint {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scn.nextInt();
            }
        }

        int row = 0;
        int col = 0;
        int dir = 0;

        while (row >= 0 && row < n && col >= 0 && col < m) {
            if (a[row][col] == 1) {
                dir = dir + 1;
            }
            dir = dir % 4;

            if (dir == 0) {
                col++;
            }
            else if (dir == 1) {
                row++;
            }
            else if (dir == 2) {
                col--;
            }
            else if (dir == 3) {
                row--;
            }
        }
        if (col == -1) col = 0;
        if (row == -1) row = 0;
        if (col == m) col = m - 1;
        if (row == n) row = n - 1;

        System.out.println(row);
        System.out.println(col);

    }

}
