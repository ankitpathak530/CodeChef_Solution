package Recursion_BackTracing;

public class LexicographicalOrder_Recursion {

	public static void main(String[] args) {

		   int n =1000;
		   
           for(int i=1; i<9; i++) {
        	    dfs(n,i);
           }
	}
	public static void dfs(int n, int i) {
		
		if(i > n) {
			return;
		}
		System.out.println(i);
		
		for(int j=0; j<10; j++) {
			dfs(n,i*10+j);
		}
	}
}
