class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";

        int maxLen = 0;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            // for odd substrings
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            // for even substrings
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    ans = s.substring(l, r + 1);
                }
                l--;
                r++;
            }
        }

        return ans;
    }
}