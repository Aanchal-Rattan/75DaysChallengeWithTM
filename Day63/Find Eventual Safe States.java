class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Boolean> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (check(i, graph, mp)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean check(int i, int[][] graph, Map<Integer, Boolean> mp) {

        if (mp.containsKey(i))
            return mp.get(i);
        mp.put(i, false);
        for (int j = 0; j < graph[i].length; j++) {
            if (!check(graph[i][j], graph, mp)) {
                return false;
            }
        }
        mp.put(i, true);
        return mp.get(i);
    }
}