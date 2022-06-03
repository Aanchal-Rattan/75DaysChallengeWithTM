class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        int wordLen = beginWord.length();

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                char[] currWord = queue.poll().toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char temp = currWord[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        currWord[j] = c;
                        String nextWord = new String(currWord);

                        if (set.contains(nextWord)) {
                            if (nextWord.equals(endWord))
                                return level + 1;
                            queue.add(nextWord);
                            set.remove(nextWord);
                        }
                        currWord[j] = temp;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}