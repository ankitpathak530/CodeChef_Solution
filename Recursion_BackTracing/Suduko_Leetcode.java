package Recursion_BackTracing;

public class Suduko_Leetcode {


	public static void main(String[] args) {
	       int value = 7;
           char ch = Integer.toString(value).charAt(0);
           System.out.println(ch);
	}
	
	
	public static boolean isPossible(int[][] ar, int x, int y, int value) {
		//entire row check
		for(int col=0; col<ar[0].length; col++) {
			if(ar[x][col] == value) {
				return false;
			}
		}
		
		//entire column check
		for(int row=0; row<ar.length; row++) {
			if(ar[row][y] == value) {
				return false;
			}
		}
		
		// matrix check
		int sumi = 3 * x/3;    //to get row value of top-left corner
		int sumj = 3 * y/3;   // to get col value of top-left corner
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(ar[sumi+i][sumj+j] == value) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void display(int[][] ar) {
		for(int i=0; i<ar.length; i++) {
			for(int j=0; j<ar[0].length; j++) {
				System.out.print(ar[i][j]+"  ");
			}System.out.println();
		}
	}
	
	
	public static void solveSuduko(int[][] ar, int i, int j)
	{
		   if(i == ar.length) {
			   display(ar);
			   return;
		   }
		   
		   int nexti = 0, nextj = 0;
		   if(j == ar[0].length) {
			   nexti = i + 1; nextj = 0;	   	   
		   }else {
			   nexti = i; nextj = j + 1; 
		   }
		   
	       //if cell is not zero so we have to continue without doing anything	   
		   if(ar[i][j] != 0) {
			   solveSuduko(ar,nexti,nextj);
		   }else{
			   //trying to put all possible value
			   for(int po=1; po<10; po++) {
				   if(isPossible(ar,i,j,po)) {
					   ar[i][j] = po;
					   solveSuduko(ar,nexti,nextj);
					   ar[i][j] = 0;
				   }
			   }
		   }
		   
		   
		   
		   
	}

}
