class Solution {
    private HashMap<String, HashMap<String, Double>> map;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        int len = values.length;
        int numQ = queries.size();
        double[] ans = new double[numQ];

        for (int i = 0; i < len; i++) {
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            Double val = values[i];

            if (!map.containsKey(x))
                map.put(x, new HashMap<>());
            map.get(x).put(y, val);

            if (!map.containsKey(y))
                map.put(y, new HashMap<>());
            map.get(y).put(x, 1 / val);
        }

        for (int i = 0; i < numQ; i++) {
            HashSet<String> seen = new HashSet<>();
            ans[i] = Dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, seen);
        }
        return ans;
    }

    public Double Dfs(String x, String y, Double ratio, HashSet<String> seen) {
        if (seen.contains(x))
            return -1.0;
        seen.add(x);

        if (!map.containsKey(x))
            return -1.0;

        if (map.get(x).containsKey(y))
            return ratio * map.get(x).get(y);

        for (Map.Entry<String, Double> entry : map.get(x).entrySet()) {
            Double ans = Dfs(entry.getKey(), y, entry.getValue() * ratio, seen);
            if (ans != -1.0)
                return ans;
        }
        return -1.0;
    }
}