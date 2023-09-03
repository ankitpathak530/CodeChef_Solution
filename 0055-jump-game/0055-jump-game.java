class Solution {
    public boolean canJump(int[] nums) {
             int[] dp = new int[nums.length];
            

             return solve(nums, 0, dp);
    }

    private boolean solve(int[] nums, int idx, int[] dp){

        
        if(idx >= nums.length || dp[idx] == -1){
            return false;
        }
        if(idx == nums.length-1){
            return true;
        }
      



        int steps = nums[idx]; //max step we can jump
        for(int i=steps; i>=1; i--){
            if(solve(nums, idx+i, dp))
                return true;
        }

        dp[idx] = -1;
        return false;
    }


}