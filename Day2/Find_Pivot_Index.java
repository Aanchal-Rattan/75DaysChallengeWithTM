class Solution {
    public int sum(int[] nums, int s, int e) {
        int ans = 0;
        for (int i = s; i < e; i++) {
            ans += nums[i];
        }

        return ans;
    }

    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (sum(nums, 0, i) == sum(nums, i + 1, nums.length)) {
                return i;
            }
        }
        return -1;
    }
}