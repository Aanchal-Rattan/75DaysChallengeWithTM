class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp = new int[N-1][N-1];
        for(int g = 0;g<dp.length;g++){
            for(int i = 0,j = g;j<N-1;i++,j++){
                if(g==0){
                    dp[i][j]=0;
                }else if(g==1){
                    dp[i][j] = arr[i]*arr[j]*arr[j+1];
                }else{
                    int minc = Integer.MAX_VALUE;
                    for(int k = i;k<j;k++){
                        int lc = dp[i][k];
                        int rc = dp[k+1][j];
                        int jc = arr[i]*arr[k+1]*arr[j+1];
                        int tc = lc+rc+jc;
                        if(tc<minc){
                            minc = tc;
                        }
                    }
                    dp[i][j] = minc;
                }
            }
        }

        return dp[0][N-2];
    }
}