class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0)
            return;

        int size = nums.length;
        int a = 0;
        int b = 0;
        for (int i = size - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                a = i;
                break;
            }
        }
        for (int i = size - 1; i >= 0; i--) {
            if (nums[i] > nums[a]) {
                b = i;
                break;
            }
        }
        if (a == b) {
            Arrays.sort(nums);
            return;
        }
        // Swap
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

        // reverse
        int l = a + 1;
        int r = size - 1;
        while (l < r) {
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}