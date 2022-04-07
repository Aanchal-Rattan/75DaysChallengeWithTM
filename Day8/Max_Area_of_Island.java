class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, Area(grid, i, j));
                }
            }
        }
        return max;
    }

    private int Area(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] <= 0) {
            return 0;
        }

        grid[i][j] = -1;
        int leftArea = Area(grid, i, j - 1);
        int rightArea = Area(grid, i, j + 1);
        int upArea = Area(grid, i - 1, j);
        int downArea = Area(grid, i + 1, j);

        int ans = 1 + leftArea + rightArea + upArea + downArea;

        return ans;

    }
}