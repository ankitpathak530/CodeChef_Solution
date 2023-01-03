package Recursion;

public class NQueenRecursion {

	public static void main(String[] args) {

		int n = 4;
		boolean[][] board = new boolean[n][n];
		boolean[] cols = new boolean[n];
		boolean[] nd = new boolean[2 * n - 1];
		boolean[] rd = new boolean[2 * n - 1];
		placeNQueen(board, 0, cols, nd, rd, "");
	}

	public static void placeNQueen(boolean[][] board, int row, boolean[] cols, boolean[] nd, boolean[] rd, String asf) {

		  if(row == board.length) {
			  System.out.println(asf);
			  return;
		  }
		
		  for(int c=0; c<board[0].length; c++)
		  {                                                                                                
		     if(!cols[c] && !nd[row+c] && !rd[row-c+board.length-1]) {       
                                                           
				    	 cols[c] = true;                                  
				    	 nd[row+c] = true;                                
				    	 rd[row-c+board.length-1] = true;  
				    	 board[row][c] = true;
				    	 
				    	 placeNQueen(board, row+1, cols, nd, rd, asf+ row + "-"+c+" ,");
				    	
				    	 cols[c] = false;                                  
				    	 nd[row+c] = false;                                
				    	 rd[row-c+board.length-1] = false;  
				    	 board[row][c] = false;	                                 
		           }                                                         
		  }                                                                                                                                                 
	}


}