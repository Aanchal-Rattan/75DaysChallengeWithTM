class Solution {

    public boolean helper(int mid, int[] arr, int k) {
        int count = 0;
        for (int i : arr) {
            count += (i - 1) / mid;
            if (count > k)
                return false;
        }
        return true;
    }

    public int minimumSize(int[] nums, int maxOperations) {

        int l = 1;
        int r = 0;
        for (int i : nums) {
            r = r < i ? i : r;
        }

        int ans = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (helper(mid, nums, maxOperations) == true) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return ans;

    }
}