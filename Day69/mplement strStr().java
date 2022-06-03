class Solution {
    public int strStr(String haystack, String needle) {

        int n = needle.length();
        int m = haystack.length();

        if (n == 0) {
            return 0;
        }

        int i = 0;
        int j = i + n;

        while (j <= m) {
            String sub = haystack.substring(i, j);

            if (sub.equals(needle) == true) {
                return i;
            }

            i++;
            j++;
        }
        return -1;
    }
}