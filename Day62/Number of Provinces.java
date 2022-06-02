class Solution {
    int[][] temp;

    public int findCircleNum(int[][] isConnected) {
        int provinces = 0;
        temp = isConnected;
        for (int i = 0; i < isConnected.length; i++) {
            provinces += disconnect(i);
        }
        return provinces;
    }

    private int disconnect(int i) {
        if (temp[i][i] == 0)
            return 0;
        temp[i][i] = 0;
        for (int j = 0; j < temp[i].length; j++)
            if (temp[i][j] == 1)
                disconnect(j);
        return 1;
    }
}