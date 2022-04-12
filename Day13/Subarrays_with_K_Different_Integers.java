class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    // helper - to count
    public int helper(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, end = 0, ans = 0;
        while (end < nums.length) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while (start <= end && map.size() > k) {
                if (map.containsKey(nums[start]))
                    map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0)
                    map.remove(nums[start]);
                start++;
            }
            ans += (end - start + 1);
            end++;
        }
        return ans;
    }
}