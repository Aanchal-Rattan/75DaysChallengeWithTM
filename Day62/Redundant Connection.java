class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] dSet = new int[1001];
        for (int i = 0; i < dSet.length; i++) {
            dSet[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            while (u != dSet[u]) {
                u = dSet[u];
            }
            while (v != dSet[v]) {
                v = dSet[v];
            }
            if (v == u) {
                return edges[i];
            }

            else {
                dSet[v] = u;
            }
        }
        return new int[] { -1, -1 };
    }
}