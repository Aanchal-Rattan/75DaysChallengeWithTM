class Solution {
    public int characterReplacement(String s, int k) {
        int st = 0;
        int total = 0; // total alphabets need to obe repleaced
        int max_length = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
            total = Math.max(total, map.get(character));
            if (i - st + 1 - total > k) {
                char ch = s.charAt(st);
                map.put(ch, map.get(ch) - 1);
                st++;

            }
            max_length = Math.max(max_length, i - st + 1);
        }
        return max_length;
    }
}