class Solution {
    public int maxArea(int[] height) {
        int n = height.length-1;

        int leftMostGrt = 0, rightMostGrt = n;

        int maxAmountWater = 0, skip = 0;

        while(leftMostGrt < rightMostGrt){
            int min = Math.min(height[leftMostGrt], height[rightMostGrt]);
             
            maxAmountWater = Math.max(maxAmountWater, min * (n-skip));

            if(height[leftMostGrt] < height[rightMostGrt])
                leftMostGrt++;
            else
                rightMostGrt--;
            skip++;
        }



        return maxAmountWater;
    }
}