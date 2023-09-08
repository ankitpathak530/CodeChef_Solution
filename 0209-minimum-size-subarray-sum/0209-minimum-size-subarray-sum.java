public class Solution{
public int minSubArrayLen(int target, int[] nums) {
        
        int i = 0, j = 0, sum = 0, mn = Integer.MAX_VALUE, n = nums.length;


        while(j < n){
            sum += nums[j];
            while(sum>=target){
                sum -= nums[i];
                mn = Math.min(j-i+1, mn);
                i++;
            }
            j++;
        }

        return mn==Integer.MAX_VALUE ? 0 : mn;            
      }
}