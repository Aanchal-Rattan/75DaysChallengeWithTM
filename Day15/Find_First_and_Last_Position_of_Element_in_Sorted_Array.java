class Solution {
    public int search(int[] nums, int target, boolean findStartIndex) {
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (target > nums[nums.length - 1]) {
                return ans;
            }

            if (nums[m] == target) {
                ans = m;
                if (findStartIndex == true)
                    r = m - 1;
                else
                    l = m + 1;
            }

            else if (target < nums[m]) {
                r = m - 1;

            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        int start = search(nums, target, true);
        int end = search(nums, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }
}