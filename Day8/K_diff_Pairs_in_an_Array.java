class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0;
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);

        }
        for (int i : map.keySet()) {
            if ((k == 0 && map.get(i) > 1) || (k > 0 && map.containsKey(i + k)))
                c++;
        }
        return c;
    }
}