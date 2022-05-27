class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                    ans = Math.max(ans, lis[i]);
                }
            }
        }
        return ans;
    }
}