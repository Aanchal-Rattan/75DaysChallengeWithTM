class StreamChecker {
    Trie trie;
    StringBuilder sb;

    public StreamChecker(String[] words) {
        trie = new Trie();
        sb = new StringBuilder();
        for (String word : words) {
            trie.addWord(word);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        return trie.search(sb.toString());
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode rt = root;
        int n = word.length();
        for (int i = n - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (rt.children[ch - 'a'] == null) {
                rt.children[ch - 'a'] = new TrieNode();
            }
            rt = rt.children[ch - 'a'];
        }
        rt.isWord = true;
    }

    public boolean search(String word) {
        TrieNode rt = root;
        int n = word.length();
        for (int i = n - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (rt.children[ch - 'a'] == null) {
                return false;
            }
            rt = rt.children[ch - 'a'];
            if (rt.isWord)
                return true;
        }
        return rt.isWord;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
