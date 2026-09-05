class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        // Case A: house 0 allowed, house n-1 excluded -> range [0, n-2]
        Integer[] memoA = new Integer[n];
        int resultA = helper(nums, 0, n - 2, memoA);
        // Case B: house n-1 allowed, house 0 excluded -> range [1, n-1]
        Integer[] memoB = new Integer[n];
        int resultB = helper(nums, 1, n - 1, memoB);
        return Math.max(resultA, resultB);
    }
    // Top-down helper: max money robbing houses in [start, end], no two adjacent
    private int helper(int[] nums, int start, int end, Integer[] memo) {
        return dfs(nums, start, end, start, memo);
    }
    private int dfs(int[] nums, int i, int end, int start, Integer[] memo) {
        if (i > end) return 0; // out of allowed range -> base case
        int idx = i - start; // normalize index for memo array
        if (memo[idx] != null) return memo[idx];
        // Choice 1: skip house i
        int skip = dfs(nums, i + 1, end, start, memo);
        // Choice 2: rob house i, then jump to i+2
        int take = nums[i] + dfs(nums, i + 2, end, start, memo);
        int best = Math.max(skip, take);
        memo[idx] = best;
        return best;
    }
}