package Recursion_BackTracing;

public class JosephKillProblem {

	public static void main(String[] args) {
		 System.out.println(killKth(7,4));
	}
	
	
	public static int killKth(int n, int k) {
		
		 if(n == 1) 
			 return 0;
		 
		 int x = killKth(n-1,k);
		 int y = (x+k)%n;
		 return y;
	}

}
