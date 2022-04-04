class Solution {
    public void rotate(int[][] matrix) {
        int n =matrix.length ;
        
         for(int i=0; i<n  ;i++){
            int l= 0;
            int r = n-1;
            while(l<r){
                int temp = matrix[l][i];
                matrix[l][i] = matrix[r][i];
                matrix[r][i] = temp;
                l++;
                r--;
            }
        }
        
         for(int i=0; i<n ; i++ ){
            for(int j=i ; j < n ; j++ ){
                int temp = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i] = temp;
            }
        }
       
    }
}