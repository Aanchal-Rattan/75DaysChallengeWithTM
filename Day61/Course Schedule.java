class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> visitSet = new HashSet<>();

        for (int i = 0; i < numCourses; i++)
            map.put(i, new HashSet<>());

        for (int[] edge : prerequisites)
            map.get(edge[0]).add(edge[1]);

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visitSet))
                return false;
        }

        return true;
    }

    private boolean dfs(int curr, Map<Integer, Set<Integer>> dep, Set<Integer> visitSet) {
        if (visitSet.contains(curr))
            return false;
        if (dep.get(curr).isEmpty())
            return true;

        visitSet.add(curr);
        for (int pre : dep.get(curr)) {
            if (!dfs(pre, dep, visitSet))
                return false;
        }

        visitSet.remove(curr);
        dep.get(curr).clear();

        return true;
    }
}