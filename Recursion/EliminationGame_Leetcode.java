package Recursion;

public class EliminationGame_Leetcode {

	public static void main(String[] args) {
		
		System.out.println(new EliminationGame_Leetcode().new Solution().lastRemaining(6));
 
	}
	class Solution {
		Solution(){}
	    public int lastRemaining(int n) {
	      
	      boolean flag = true; // odd or even
	      int head = 1, step = 1, remain = n;
	      while(remain>1){

	            if(flag || remain%2 == 1){
	                head = head + step;
	            }
	            step*=2;
	            remain/=2;
	            flag = !flag;
	      }
	      return head;
	       
	    }
	}
	
	
	
	
	
}
