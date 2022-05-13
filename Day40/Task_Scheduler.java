class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : tasks)
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        int cycles = 0;
        PriorityQueue<Integer> mxh = new PriorityQueue<>((a, b) -> b - a);
        mxh.addAll(map.values());
        while (!mxh.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                if (!mxh.isEmpty())
                    temp.add(mxh.remove());
            }
            for (int tval : temp) {
                if (--tval > 0)
                    mxh.add(tval);
            }
            cycles += mxh.isEmpty() ? temp.size() : n + 1;
        }
        return cycles;
    }
}