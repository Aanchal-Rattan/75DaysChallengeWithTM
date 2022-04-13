class Solution {
    public int countNegatives(int[][] grid) {
        // Brute Force
        // int c=0;
        // for(int i=0; i<grid.length ; i++ ){
        // for(int j=0; j<grid[0].length ; j++ ){
        // if(grid[i][j]<0){
        // c++;
        // }
        // }
        // }
        // return c;

        // Binary Search
        int ans = 0;
        for (int[] arr : grid) {
            int l = 0;
            int r = arr.length - 1;

            while (l <= r) {
                int mid = (l + r) / 2;
                if (arr[mid] >= 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            ans += arr.length - l;
        }
        return ans;

    }
}