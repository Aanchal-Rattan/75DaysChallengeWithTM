class Solution {
    public static void solve(int[][] m, int[][] sol, int n, ArrayList<String> ans, String str, int i, int j) {
        if (i == n - 1 && j == n - 1) {
            ans.add(str);
            return;
        }

        if (i + 1 < n && sol[i + 1][j] == 0 && m[i + 1][j] == 1) {
            sol[i][j] = 1;
            solve(m, sol, n, ans, str + 'D', i + 1, j);
            sol[i][j] = 0;
        }
        if (i - 1 >= 0 && sol[i - 1][j] == 0 && m[i - 1][j] == 1) {
            sol[i][j] = 1;
            solve(m, sol, n, ans, str + 'U', i - 1, j);
            sol[i][j] = 0;
        }
        if (j - 1 >= 0 && sol[i][j - 1] == 0 && m[i][j - 1] == 1) {
            sol[i][j] = 1;
            solve(m, sol, n, ans, str + 'L', i, j - 1);
            sol[i][j] = 0;
        }
        if (j + 1 < n && sol[i][j + 1] == 0 && m[i][j + 1] == 1) {
            sol[i][j] = 1;
            solve(m, sol, n, ans, str + 'R', i, j + 1);
            sol[i][j] = 0;
        }
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int[][] sol = new int[n][n];
        ArrayList<String> ans = new ArrayList<>();
        String str = "";
        if (m[0][0] == 1)
            solve(m, sol, n, ans, str, 0, 0);
        return ans;
    }
}