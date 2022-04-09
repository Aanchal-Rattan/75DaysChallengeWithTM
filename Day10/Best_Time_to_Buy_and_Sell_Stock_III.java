class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n == 0)
            return 0;

        int[] left = new int[n];
        left[0] = 0;
        int[] right = new int[n];
        right[n - 1] = 0;
        int min = prices[0];
        int max = prices[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = min > prices[i] ? prices[i] : min;
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = max < prices[i] ? prices[i] : max;
        }
        int ans = right[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(left[i - 1] + right[i], ans);
        }
        return ans;
    }
}