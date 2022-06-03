class Solution {
    public List<List<String>> findLadders(String bword, String eword, List<String> list) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wset = new HashSet<>(list);
        if (!wset.contains(eword))
            return res;

        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(bword));
        wset.remove(bword);
        List<String> tempList = new ArrayList<>();
        boolean isFound = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> visited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> plist = queue.poll();
                String pword = plist.get(plist.size() - 1);
                visited.add(pword);
                List<String> adjWords = getAdjWords(pword, wset);
                for (String s : adjWords) {
                    List<String> nlist = new ArrayList<>(plist);
                    nlist.add(s);
                    if (eword.equals(s)) {
                        res.add(nlist);
                        isFound = true;
                    } else if (!isFound) {
                        queue.offer(nlist);
                    }
                }
            }
            for (String s : visited)
                wset.remove(s);
            if (isFound)
                break;
        }

        return res;
    }

    private List<String> getAdjWords(String s, Set<String> wset) {
        List<String> res = new ArrayList<>();
        for (int j = 0; j < s.length(); j++) {
            for (char k = 'a'; k <= 'z'; k++) {
                char[] charArr = s.toCharArray();
                charArr[j] = k;
                String nword = new String(charArr);
                if (wset.contains(nword))
                    res.add(nword);
            }
        }
        return res;
    }
}