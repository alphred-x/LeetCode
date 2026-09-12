class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        java.util.Arrays.fill(dp, -1);
        return solve(arr, k, 0, dp);
    }
    int solve(int[] arr, int k, int index, int[] dp) {
        if (index == arr.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int maxValue = 0;
        int maxSum = 0;
        for (int i = 0; i < k && index + i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[index + i]);
            int currentSum = maxValue * (i + 1);
            int totalSum = currentSum + solve(arr, k, index + i + 1, dp);
            maxSum = Math.max(maxSum, totalSum);
        }
        dp[index] = maxSum;
        return dp[index];
    }
}