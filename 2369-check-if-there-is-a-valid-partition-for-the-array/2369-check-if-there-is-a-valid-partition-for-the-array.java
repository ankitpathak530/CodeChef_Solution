class Solution {
    public boolean validPartition(int[] nums) {
        
         int n = nums.length;
         int[] memo = new int[100001];
        
         return helper(0, nums, memo, n);
    }
    
    private boolean helper(int idx, int[] nums, int[] memo, int n){
        
        if(idx >= n){
            return true;
        }
        
        if(memo[idx] != 0){
            return memo[idx] == 1 ? true : false;
        }
        
        
        boolean result = false;
        
        //1st rule
        if(idx+1 < n && nums[idx] == nums[idx+1]){
            result = helper(idx+2, nums, memo, n);
            if(result) return true;
        }
        
        //2nd rule
        if(idx+2 < n && nums[idx] == nums[idx+1] && nums[idx] == nums[idx+2]){
            result = helper(idx+3, nums, memo, n);
            if(result) return true;
        }
        
        //3rd rule
        if(idx+2 < n && nums[idx]+1 == nums[idx+1] && nums[idx+1]+1 == nums[idx+2]){
            result = helper(idx+3, nums, memo, n);
            if(result) return true;
        }
        
        
        memo[idx] = result ? 1 : 2; //true 1 false 2
        return result;      
        
    }
}