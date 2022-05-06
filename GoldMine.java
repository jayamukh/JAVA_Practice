public class GoldMine {

    private int[][] goldMine = null;

    public GoldMine(int[][] goldMine) {
        this.goldMine = goldMine;
    }


    public int getMaxGold() {

        if (goldMine == null || goldMine.length == 0) {
            return 0;

        }
        int rowLength = goldMine.length;
        int colLength = goldMine[0].length;


        int[][] goldMineTable = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                goldMineTable[i][j] = 0;

            }

        }
        for (int col = colLength - 1; col >= 0; col--) {
            for (int row = 0; row < rowLength; row++) {

                int right = col == colLength - 1 ? 0
                                                 : goldMineTable[row][col + 1];

                int rightUp = (row == 0 || col == colLength - 1 ? 0
                                                                : goldMineTable[row - 1][col + 1]);

                int rightDown = (row == rowLength - 1 || col == colLength - 1 ? 0
                                                                              :
                                 goldMineTable[row + 1][col + 1]);

                goldMineTable[row][col] = goldMine[row][col]
                        + Math.max(rightUp, Math.max(right, rightDown));

            }

        }
        int max = 0;

        for (int i = 0; i < rowLength; i++) {
            max = max < goldMineTable[i][0] ? goldMineTable[i][0] : max;

        }
        return max;

    }

    public int rec(int[][] nums, int i, int j, int n, int m) {
        if (j == m - 1) {
            return nums[i][j];
        }

        int ans = 0;

        if (i - 1 >= 0)
            ans = Math.max(ans, rec(nums, i - 1, j + 1, n, m));

        ans = Math.max(ans, rec(nums, i, j + 1, n, m));
        if (i + 1 < n)
            ans = Math.max(ans, rec(nums, i + 1, j + 1, n, m));
        return ans + nums[i][j];
    }

    public int tab_gold(int[][] nums, int n, int m) {
        int[][] dp = new int[n][m];

        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1) {
                    dp[i][j] = nums[i][j];
                }
                else if (i == 0) {
                    dp[i][j] = nums[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                }
                else if (i == n - 1) {
                    dp[i][j] = nums[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                }
                else {
                    dp[i][j] = nums[i][j] + Math
                            .max(Math.max(dp[i - 1][j + 1], dp[i][j + 1]), dp[i + 1][j + 1]);
                }

            }
        }

        int max_gold = 0;

        for (int i = 0; i < n; i++) {
            max_gold = Math.max(max_gold, dp[i][0]);
        }

        return max_gold;
    }

    public static void main(String[] args) {

        /*int[][] mine = {
                { 1, 3, 1, 5 },
                { 2, 2, 4, 1 },
                { 5, 0, 2, 3 },
                { 0, 6, 1, 2 }
        };*/

        int[][] mine = {
                { 0, 1, 4, 2, 8, 2 },
                { 4, 3, 6, 5, 0, 4 },
                { 1, 2, 4, 1, 4, 6 },
                { 2, 0, 7, 3, 2, 2 },
                { 3, 1, 5, 9, 2, 4 },
                { 2, 7, 0, 8, 5, 1 }
        };

        GoldMine goldMine = new GoldMine(mine);
        //int maxGold = goldMine.getMaxGold();
        System.out.println(goldMine.tab_gold(mine, 6, 6));

    }


}
