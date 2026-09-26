import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));        
        int n = pairs.length;
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }   
        return solve(pairs, 0, -1, dp);
    }   
    int solve(int[][] pairs, int current, int previous, int[][] dp) {
        if (current == pairs.length) {
            return 0;
        }
        if (dp[current][previous + 1] != -1) {
            return dp[current][previous + 1];
        }
        int skip = solve(pairs, current + 1, previous, dp);
        int take = 0;
        if (previous == -1 || pairs[current][0] > pairs[previous][1]) {
            take = 1 + solve(pairs, current + 1, current, dp);
        }
        dp[current][previous + 1] = Math.max(skip, take);
        return dp[current][previous + 1];
    }
}