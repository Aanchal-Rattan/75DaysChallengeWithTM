class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        while (n > 0) {
            if (nums[n] == nums[n - 1]) {
                break;
            }
            n--;
        }
        return nums[n];
    }
}