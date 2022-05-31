class Solution {

    public int helper(int[] coins, int amount, int[] dp) {

        if (amount == 0)
            return 0;

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int temp = 0;
            if (amount - coins[i] >= 0) {
                if (dp[amount - coins[i]] != -1) {
                    temp = dp[amount - coins[i]];
                } else {
                    temp = helper(coins, amount - coins[i], dp);
                }

                if (temp != Integer.MAX_VALUE) {
                    ans = Math.min(ans, temp + 1);
                }
            }

        }
        return dp[amount] = ans;

    }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, -1);
        dp[0] = 0;

        int res = helper(coins, amount, dp);
        return res == Integer.MAX_VALUE ? -1 : res;

    }
}