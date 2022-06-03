class Solution {
    class Data implements Comparable<Data> {
        int val;
        int movesrem;

        Data(int val, int movesrem) {
            this.val = val;
            this.movesrem = movesrem;
        }

        public int compareTo(Data o) {
            return o.movesrem - this.movesrem;
        }
    }

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        HashMap<Integer, Integer>[] graph = new HashMap[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].put(edge[1], edge[2]);
            graph[edge[1]].put(edge[0], edge[2]);
        }
        boolean[] vis = new boolean[n];

        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.add(new Data(0, maxMoves));
        int total = 1;
        while (pq.size() > 0) {
            Data data = pq.remove();
            if (vis[data.val] == true) {
                total -= 1;

                continue;
            }
            vis[data.val] = true;

            HashMap<Integer, Integer> nbrs = graph[data.val];
            for (int node : nbrs.keySet()) {
                int remaining = nbrs.get(node);
                if (vis[node] == false || remaining > 0) {
                    if (remaining <= data.movesrem) {
                        if (remaining == data.movesrem)
                            total -= 1;
                        total += remaining + 1;
                        nbrs.put(node, 0);
                        graph[node].put(data.val, 0);

                    } else {
                        total += data.movesrem;
                        nbrs.put(node, remaining - data.movesrem);
                        graph[node].put(data.val, remaining - data.movesrem);
                    }

                    if (data.movesrem - remaining - 1 >= 0)
                        pq.add(new Data(node, data.movesrem - remaining - 1));
                }
            }
        }

        return total;

    }
}