class Solution {
    public List<List<Integer>> two(int[] nums, int s, int e, int target) {
        int l = s;
        int r = e;

        List<List<Integer>> ans = new ArrayList<>();

        while (l < r) {
            if (l != s && nums[l] == nums[l - 1]) {
                l++;
                continue;
            }

            int sum = nums[l] + nums[r];

            if (sum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[l]);
                temp.add(nums[r]);
                ans.add(temp);
                l++;
                r--;
            } else if (sum > target)
                r--;
            else
                l++;
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int size = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        if (size < 3)
            return ans;

        Arrays.sort(nums);
        for (int i = 0; i < size - 1; i++) {

            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            int val1 = nums[i];
            int target = 0 - val1;

            List<List<Integer>> temp = two(nums, i + 1, size - 1, target);

            for (List l : temp) {
                l.add(val1);
                ans.add(l);
            }

        }
        return ans;

    }
}