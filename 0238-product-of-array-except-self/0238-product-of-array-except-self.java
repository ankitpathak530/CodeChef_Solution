class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int countZero = 0;
        int count = 1;
         
        for(int i=0; i<n; i++){
            if(nums[i] == 0){
               countZero++;
            }else{
                count *= nums[i];
            }
        }
       
        if(countZero >= 2){
            return result;
        }

        for(int i=0; i<n; i++){
             result[i] = nums[i] == 0 ? count : countZero == 1 ? 0 : count/nums[i];
        }

        return result;
    }
}