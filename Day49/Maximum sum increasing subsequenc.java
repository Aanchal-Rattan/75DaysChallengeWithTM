class Solution {
    public int maxSumIS(int arr[], int n) {
        int[] dp = new int[n];
        int ans = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (max == 0) {
                        max = dp[j];
                    } else if (max < dp[j]) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = arr[i] + max;
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}