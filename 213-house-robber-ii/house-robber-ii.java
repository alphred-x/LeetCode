class Solution {
    public int rob(int[] nums) {
        // Edge cases for very small neighborhoods
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        // We need two separate caches for our two different scenarios
        Integer[] memo1 = new Integer[nums.length];
        Integer[] memo2 = new Integer[nums.length];
        // Scenario 1: Consider houses from index 0 up to length - 2
        int max1 = solve(nums, 0, nums.length - 2, memo1);
        // Scenario 2: Consider houses from index 1 up to length - 1
        int max2 = solve(nums, 1, nums.length - 1, memo2);
        // Return the absolute maximum of the two possible scenarios
        return Math.max(max1, max2);
    }
    private int solve(int[] nums, int currentIndex, int endIndex, Integer[] memo) {
        // Base case: If our pointer steps out of the allowed bounds, return 0 money
        if (currentIndex > endIndex) {
            return 0;
        }
        // Memoization Check: If we already solved this exact index, return the cached result instantly
        if (memo[currentIndex] != null) {
            return memo[currentIndex];
        }
        // The Recursive Choices:
        // 1. Rob THIS house (add money, and skip the adjacent house by jumping 2 steps)
        int robCurrent = nums[currentIndex] + solve(nums, currentIndex + 2, endIndex, memo);
        // 2. Skip THIS house (add 0 money, and evaluate the very next house)
        int skipCurrent = solve(nums, currentIndex + 1, endIndex, memo);
        // Cache the best possible outcome for this index before returning it up the tree
        memo[currentIndex] = Math.max(robCurrent, skipCurrent);
        return memo[currentIndex];
    }
}