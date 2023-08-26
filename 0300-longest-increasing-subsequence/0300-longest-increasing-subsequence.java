class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length]; // Change the dimensions of dp array

        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, 0, -1, dp);
    }

    public int solve(int[] nums, int i, int p, int[][] dp) {
        if (i >= nums.length) {
            return 0;
        }

        if (dp[p + 1][i] != -1) { // Corrected indices here
            return dp[p + 1][i];
        }

        int take = 0;
        if (p == -1 || nums[i] > nums[p]) {
            take = 1 + solve(nums, i + 1, i, dp);
        }

        int skip = solve(nums, i + 1, p, dp);

        int result = Math.max(take, skip);
        dp[p + 1][i] = result; // Corrected indices here
        return dp[p + 1][i];   // Corrected indices here
    }
}
