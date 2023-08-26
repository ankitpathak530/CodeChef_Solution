class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a,b)-> a[0] - b[0]);
        int memo[][] = new int[n+1][n+1];   
        for(int i=0; i<n; i++){
           Arrays.fill(memo[i],-1);
        }  
        return solve(pairs, 0, -1, memo);
      
    }
    private int solve(int[][] pairs, int i, int p, int[][] memo){
         if(i >= pairs.length){
             return 0;
         }

        if(memo[p+1][i] != -1){
            return memo[p+1][i];
        }

         int take = 0;
         if(p == -1 || (pairs[i][0] < pairs[i][1] && pairs[p][1] < pairs[i][0])){
             take = 1 + solve(pairs, i+1, i, memo);
         }

        int skip = solve(pairs, i+1, p, memo);


        int result = Math.max(take, skip);
        memo[p+1][i]=result;
        return result;
    }
}