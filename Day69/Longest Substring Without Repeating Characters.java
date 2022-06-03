class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        ArrayList<Character> list = new ArrayList();
        for (int i = 0; i < s.length(); i++) {
            int temp = 0;

            while ((i + temp) < s.length() && !list.contains(s.charAt(i + temp))) {
                list.add(s.charAt(i + temp));
                temp++;
            }

            if (max < temp) {
                max = temp;

            }
            list.clear();
        }

        return max;
    }
}