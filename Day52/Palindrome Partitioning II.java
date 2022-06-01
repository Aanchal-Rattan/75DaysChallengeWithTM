public class Solution {
    private Integer dp[];
    private Boolean dpIsPalindrome[][];

    public int minCut(String A) {
        dp = new Integer[A.length()];
        dpIsPalindrome = new Boolean[A.length()][A.length()];
        return minCut(A, 0, A.length() - 1);
    }

    public int minCut(String A, int s, int n) {
        if (s == n || isPalindrome(A, s, n)) {
            return 0;
        }

        if (dp[s] != null) {
            return dp[s];
        }

        int ans = n;
        for (int i = s; i <= n; i++) {
            if (isPalindrome(A, s, i)) {
                ans = Math.min(ans, 1 + minCut(A, i + 1, n));
            }
        }
        return dp[s] = ans;
    }

    public boolean isPalindrome(String s, int start, int end) {

        if (dpIsPalindrome[start][end] != null)
            return dpIsPalindrome[start][end];

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return dpIsPalindrome[start][end] = false;
            }
            start++;
            end--;
        }
        return dpIsPalindrome[start][end] = true;
    }
}