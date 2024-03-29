class Solution {
    public int firstMissingPositive(int[] nums) {
        // 1. make every elements in range i.e 0-n
        int n = nums.length;
        Boolean bool = false;
        // System.out.println(n);
        for (int i = 0; i < n; i++) {

            if (nums[i] == 1)
                bool = true;

            if (nums[i] < 1 || nums[i] > n)
                nums[i] = 1;
        }

        // 2. if one is not present then return one
        if (bool == false)
            return 1;

        // 3. make the occuring index as -1

        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]);
            nums[idx - 1] = -Math.abs(nums[idx - 1]);
        }

        // 4. find the missing no.
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i + 1;
        }

        return n + 1;
    }
}