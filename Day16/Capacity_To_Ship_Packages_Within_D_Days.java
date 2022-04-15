class Solution {

    public boolean helper(int mid, int[] arr, int n, int d) {
        int sum = 0;
        int days = 1;
        for (int i : arr) {
            if (sum + i <= mid)
                sum += i;
            else {
                sum = i;
                days++;
            }
        }

        if (days <= d)
            return true;
        return false;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int i : weights) {
            if (i > low)
                low = i; // maximum elements
            high += i; // sum of elements
        }
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (helper(mid, weights, weights.length, days)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }
}