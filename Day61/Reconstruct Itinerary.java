class Solution {
    HashMap<String, PriorityQueue<String>> graph;
    LinkedList<String> ans;

    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        ans = new LinkedList<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String nbr = ticket.get(1);
            PriorityQueue<String> pq = graph.getOrDefault(src, new PriorityQueue<>());
            pq.add(nbr);
            graph.put(src, pq);
        }
        dfs("JFK");
        return ans;
    }

    private void dfs(String src) {
        PriorityQueue<String> nbrs = graph.get(src);

        while (nbrs != null && nbrs.size() > 0) {
            String nbr = nbrs.remove();
            dfs(nbr);
        }
        ans.addFirst(src);
    }
}