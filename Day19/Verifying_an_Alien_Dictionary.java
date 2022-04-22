class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int alpha[] = new int[26];
        int idx = 0;

        // Array Index as alphabets and inserting the order in alien language as array
        // element
        for (char c : order.toCharArray()) {
            alpha[c - 'a'] = idx++;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i]; // current word
            String next = words[i + 1]; // next word

            int length = curr.length() > next.length() ? next.length() : curr.length();

            if (length != curr.length() && curr.startsWith(next)) {
                return false;
            }
            for (int j = 0; j < length; j++) {
                if (alpha[curr.charAt(j) - 'a'] > alpha[next.charAt(j) - 'a']) {
                    return false;
                }
                if (alpha[curr.charAt(j) - 'a'] < alpha[next.charAt(j) - 'a']) {
                    break;
                }
            }

        }
        return true;
    }
}