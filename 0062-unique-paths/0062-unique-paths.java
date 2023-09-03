class Solution {
    public int uniquePaths(int m, int n) {
        
        int board[][] = new int[m][n];
        board[m-1][n-1] = 1;

        if(m == 1) return 1;




        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){

                
                int rsum = 0;
                int dsum = 0;

                if(j+1 < n) rsum = board[i][j+1];
                if(i+1 < m) dsum = board[i+1][j];

                if(board[i][j] == 0){
                    board[i][j] = rsum+dsum;
                }
            }
        }

        return board[0][0];
    }
}