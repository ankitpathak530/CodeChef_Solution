class Solution {
    
    int dp[] = new int[46];
    
    public int climbStairs(int n) {
        
         if(n  == 0){
             return 1;
         }
        else if(n < 0){
            return 0;
        }
         else if(dp[n] != 0){
             return dp[n];
         }
        
     
         int count1 = climbStairs(n-1);
         int count2 = climbStairs(n-2);
        
         dp[n] = count1+count2;
         return dp[n];        
    }
    
  
}