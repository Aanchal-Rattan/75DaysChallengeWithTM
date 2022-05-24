class Solution {

    public void helper(int l, int r, String s, List<String> ans) {
        if (l == 0 && r == 0) {
            ans.add(s);
            return;
        }
        if (l == r) {
            helper(l - 1, r, s + '(', ans);
        } else if (l == 0) {
            helper(l, r - 1, s + ')', ans);
        } else if (l < r) {
            helper(l - 1, r, s + '(', ans);
            helper(l, r - 1, s + ')', ans);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String s = "";
        helper(n, n, s, ans);
        return ans;
    }
}