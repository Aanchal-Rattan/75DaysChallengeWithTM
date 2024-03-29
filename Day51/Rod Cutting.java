class Solution {
    public int cutRod(int price[], int n) {
        // code here
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < i) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - i], dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
    }
}