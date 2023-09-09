class Solution {
    int memo[]; // No need to specify the size here

    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1]; // Initialize the memo array with size target + 1
        Arrays.fill(memo, -1);
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (target < 0) return 0;
        if (target == 0) return 1;

        if (memo[target] != -1) return memo[target];

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += helper(nums, target - nums[i]);
        }

        memo[target] = ans;
        return ans;
    }
}
