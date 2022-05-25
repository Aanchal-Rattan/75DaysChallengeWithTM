class Solution {

    public void helper(int idx, int k, int n, List<Integer> asf, List<List<Integer>> output) {

        if (asf.size() == k) {
            output.add(new ArrayList(asf)); // copy the asf in new arraylist
            return;
        }
        for (int i = idx; i <= n; i++) {
            asf.add(i);
            helper(i + 1, k, n, asf, output);
            asf.remove(asf.size() - 1);
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        helper(1, k, n, new ArrayList(), output);
        return output;
    }
}