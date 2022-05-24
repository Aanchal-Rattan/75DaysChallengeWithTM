class Solution {
    String[] arr = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public void helper(int d, List<String> ans, String s) {
        if (d == 0) {
            ans.add(s);
            return;
        }
        int temp = d % 10;
        String t = arr[temp];
        for (int i = 0; i < t.length(); i++) {
            helper(d / 10, ans, t.charAt(i) + s);
        }

    }

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String s = "";
        int d = 0;
        if (digits.equals("")) {
            return ans;
        } else
            d = Integer.parseInt(digits);
        helper(d, ans, s);
        return ans;
    }
}