class Solution {
    public int maxArea(int[] height) {
        int n = height.length-1;

        int leftMostGrt = 0;
        int rightMostGrt = n;

        int max = 0, skip = 0;

        while(leftMostGrt < rightMostGrt){
            int min = Math.min(height[leftMostGrt], height[rightMostGrt]);
             
            max = Math.max(max, min * (n-skip));

            if(height[leftMostGrt] < height[rightMostGrt]){
                leftMostGrt++;
                skip++;
            }else{
                rightMostGrt--;
                skip++;
            }
        }
        return max;
    }
}