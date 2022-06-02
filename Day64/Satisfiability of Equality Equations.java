class Solution {
    public boolean equationsPossible(String[] equations) {
        DisjointSet ds = new DisjointSet(26);
        List<String> equals = new ArrayList<>();
        List<String> notEquals = new ArrayList<>();
        for (String str : equations) {
            boolean allEquals = str.charAt(1) != '!';
            if (allEquals) {
                equals.add(str);

            } else {
                notEquals.add(str);
            }
        }

        for (String str : equals) {

            int first = str.charAt(0) - 'a';
            int second = str.charAt(3) - 'a';

            ds.union(first, second);

        }

        for (String str : notEquals) {
            int first = str.charAt(0) - 'a';
            int second = str.charAt(3) - 'a';
            if (ds.find(first) == ds.find(second)) {
                return false;
            }

        }
        return true;
    }

    public class DisjointSet {
        int n;
        int[] rank;
        int[] parent;

        public DisjointSet(int n) {
            this.n = n;
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int a) {
            if (parent[a] == a) {
                return a;
            }

            return parent[a] = find(parent[a]);
        }

        public void union(int a, int b) {
            int parA = parent[a];
            int parB = parent[b];
            if (parA == parB) {
                return;
            }

            if (rank[parA] > rank[parB]) {
                parent[parB] = parA;

            }
            if (rank[parA] < rank[parB]) {
                parent[parA] = parB;

            } else {
                parent[parB] = parA;
                rank[parA]++;
            }
        }
    }
}