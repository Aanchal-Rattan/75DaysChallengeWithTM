class Solution {
    int[] dir_i = {-1,0,+1,0};
    int[] dir_j = {0,+1,0,-1};
    
    public boolean search(char[][] board,int i,int j, int idx, String word){
        if(idx == word.length() ) return true;
    
        if(i<0 || j<0 || i>=board.length || j>=board[0].length ) return false;
        
         if(word.charAt(idx) != board[i][j] ) return false;
        
        char c = board[i][j];
        board[i][j] = '#';
        
        for( int x = 0 ; x<4 ;x++){
            boolean ans = search(board, i+dir_i[x] , j+dir_j[x] , idx+1 , word);
            if(ans){
                board[i][j] = c;
                return true;
            }
        }
         board[i][j] = c;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c= board[0].length;
        
        for(int i=0;i<r;i++  ){
            for(int j=0;j<c ;j++ ){
                if(board[i][j]!=word.charAt(0) ) continue;
                boolean ans = search(board, i,j,0,word );
                if(ans) return true;
            }
        }
        return false;
    }
}