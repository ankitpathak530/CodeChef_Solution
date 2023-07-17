class Solution {
    public List<List<String>> solveNQueens(int n) {

        int cols[] = new int[n];;
        int nd[] = new int[2*n - 1];
        int rd[] = new int[2*n - 1];

        int board[][] = new int[n][n];
        List<List<String>> list = new ArrayList<>();
        List<String> asf = new ArrayList<>();


        solve(board, 0, cols, nd, rd, list);
        return list;
        
    }


    private void solve(int[][] board, int row, int[] cols, int[] nd, int[] rd,List<List<String>> list){
        if(row == board.length){
            list.add(constructPattern(board));
            return;
        }

        for(int col=0; col<board[0].length; col++){
            if(cols[col] == 0 && nd[row+col] == 0 && rd[row-col+board.length-1] == 0 &&  board[row][col] == 0){
                 board[row][col] = 1;
                 cols[col] = 1;
                 nd[row+col] = 1;
                 rd[row-col+board.length-1] = 1;
                 
                solve(board, row+1, cols, nd, rd, list);

                board[row][col] = 0;
                cols[col] = 0;
                nd[row+col] = 0;
                rd[row-col+board.length-1] = 0;
            }
        }
    }

    private List<String> constructPattern(int[][] board){
        List<String> result = new ArrayList<>();
        
        for(int i=0; i<board.length; i++){
           StringBuffer sb = new StringBuffer("");

           for(int j=0; j<board[i].length; j++){
                 sb.append(board[i][j] == 1 ? "Q" : ".");
           }
           result.add(sb.toString());
        }
        return result;
    }

}