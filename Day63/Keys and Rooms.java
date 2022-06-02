class Solution {

    boolean visited[];

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int length = rooms.size();
        this.visited = new boolean[length];
        dfs(0, rooms);
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    void dfs(int node, List<List<Integer>> rooms) {
        visited[node] = true;
        List<Integer> childList = rooms.get(node);
        if (childList.size() > 0) {
            for (Integer child : childList) {
                if (!visited[child]) {
                    dfs(child, rooms);
                }
            }
        }
    }
}
