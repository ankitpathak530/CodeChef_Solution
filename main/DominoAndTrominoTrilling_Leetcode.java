package main;

public class DominoAndTrominoTrilling_Leetcode {

	  public int numTilings(int n) {
	        
	        if(n <= 2) return n;
	        if(n == 2) return 2;
	        if(n == 3) return 5;

	        int a = 1;
	        int b = 2;
	        int c = 5;

	        for(int i = 4; i<=n; i++){
	             int d =  ((c<<1)%1000000007 + (a)%1000000007)%1000000007; 
	             a = b;
	             b = c;
	             c = d;
	        }

	        return c;
	    }
}
