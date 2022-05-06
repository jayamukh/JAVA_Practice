/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */
// min moves required to move form (0,0) to (n,m)

import java.util.Scanner;

public class Jump_snapchat {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] memo = new int[n][m];
        System.out.println(jump_memo(arr, 0, 0, n, m, memo));


    }

    public static int jump_memo(int[][] arr, int i, int j, int n, int m, int[][] memo) {

        if (i == n - 1 && j == m - 1)
            return memo[i][j] = 0;
        if (memo[i][j] != 0) return memo[i][j];

        int ans = (int) (1e8);
        if (i + arr[i][j] < n) {
            ans = Math.min(ans, jump_memo(arr, i + arr[i][j], j, n, m, memo));
        }

        if (j + arr[i][j] < m) {
            ans = Math.min(ans, jump_memo(arr, i, arr[i][j] + j, n, m, memo));
        }

        return ans + 1;
    }
}
