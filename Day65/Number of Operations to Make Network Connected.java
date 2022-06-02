class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] c : connections) {
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(c[0]);
        }
        ArrayList<ArrayList<Integer>> comp = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                ArrayList<Integer> ans = new ArrayList<>();
                getConnectedComp(graph, i, ans, vis);
                comp.add(ans);
            }
        }
        return comp.size() - 1;
    }

    public void getConnectedComp(List<List<Integer>> graph, int src, ArrayList<Integer> ans, boolean[] vis) {
        ans.add(src);
        vis[src] = true;
        for (int e : graph.get(src)) {
            if (!vis[e])
                getConnectedComp(graph, e, ans, vis);
        }
    }
}