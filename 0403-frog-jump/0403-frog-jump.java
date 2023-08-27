class Solution {
    int dp[][];

    public boolean canCross(int[] stones) {  
        int n = stones.length;  
        dp = new int[n][n*2];

        return solve(stones, 0, 1);
    }

 
    private boolean solve(int[] stones, int idx, int step){
        
        if(idx >= stones.length-1 || dp[idx][step] == 1){
            return true;
        }
       
        if(dp[idx][step] == -1){
            return false;
        }
       
        int newElementIdx = binarySearch(stones, idx, stones[idx]+step);
        if(newElementIdx == -1){
            return false;
        }

    
        boolean s1 = solve(stones, newElementIdx, step+1);
        boolean s2 = solve(stones, newElementIdx, step);
        boolean s3 = solve(stones, newElementIdx, step-1);

        
        dp[idx][step] = (s1 || s2 || s3) ? 1 : -1;
        return dp[idx][step] == 1 ? true : false;       
    }




    private int binarySearch(int arr[], int idx, int x)
    {
        int l = idx+1, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x)
                return m;
            if (arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
}
