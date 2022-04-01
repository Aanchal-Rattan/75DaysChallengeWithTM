class Solution {
    public void moveZeroes(int[] nums) {
        int size = nums.length;
        int idx = 0;

        for (int i = 0; i < size; i++) {
            if (nums[i] != 0) {
                nums[idx] = nums[i];
                idx++;
            }
        }
        while (idx < size) {
            nums[idx] = 0;
            idx++;
        }
    }
}