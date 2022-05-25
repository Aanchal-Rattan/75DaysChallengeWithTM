class Solution {

    public void helper(int[] cand, int tar, List<List<Integer>> ans, List<Integer> asf, int idx) {
        if (tar == 0) {
            ans.add(new ArrayList(asf));
            return;
        }
        for (int i = idx; i < cand.length; i++) {
            if (i > idx && cand[i - 1] == cand[i])
                continue;
            if (cand[i] > tar)
                break;
            asf.add(cand[i]);
            helper(cand, tar - cand[i], ans, asf, i + 1);
            asf.remove(asf.size() - 1);

        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> asf = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, ans, asf, 0);
        return ans;
    }
}