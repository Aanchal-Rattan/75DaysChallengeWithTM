class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m= matrix.length;
        int n = matrix[0].length;
        int size = 0;
        int maxSize = m*n;
        int minr =0;
        int minc=0;
        int maxr= m-1;
        int maxc=n-1;
        
        ArrayList<Integer> list = new ArrayList<>();
        while(size<maxSize){
            for(int i=minr , j=minc ; j<=maxc &&  size<maxSize ; j++  ) {
                list.add(matrix[i][j]);
                size++;
            }
            minr++;
             for(int i=minr , j=maxc ; i<=maxr &&  size<maxSize ; i++){
                list.add(matrix[i][j]);
                size++;
            }
            maxc--;
             for(int i=maxr , j=maxc ; j>=minc &&  size<maxSize ; j--){
                list.add(matrix[i][j]);
                size++;
            }
            maxr--;
             for(int i=maxr , j=minc ; i>=minr &&  size<maxSize ; i--){
                list.add(matrix[i][j]);
                size++;
            }
            minc++;
        }
        return list;
        
    }
}