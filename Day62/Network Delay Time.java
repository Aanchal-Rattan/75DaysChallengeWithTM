class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            int source = time[0];
            int destination = time[1];
            int duration = time[2];
            map.putIfAbsent(source, new HashMap<>());
            map.get(source).put(destination, duration);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, K });

        boolean[] visited = new boolean[N + 1];
        int result = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int distance = curr[0];
            int node = curr[1];

            if (visited[node])
                continue;

            visited[node] = true;

            result = distance;
            N--;

            if (map.containsKey(node)) {
                for (int next : map.get(node).keySet()) {
                    pq.add(new int[] { distance + map.get(node).get(next), next });
                }
            }
        }

        return N == 0 ? result : -1;
    }
}