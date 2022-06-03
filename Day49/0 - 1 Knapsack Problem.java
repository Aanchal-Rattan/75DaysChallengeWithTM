class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) {
        // your code here
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int temp = j - wt[i - 1];
                if (j >= wt[i - 1]) {
                    if (dp[i - 1][temp] + val[i - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][temp] + val[i - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }

                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
}