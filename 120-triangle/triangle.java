import java.util.List;

class Solution {
    Integer[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new Integer[n][n];
        return tri(triangle, 0, 0);
    }
    int tri(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) {
            return 0;
        }
        if (dp[row][col] != null) {
            return dp[row][col];
        }
        int leftPath = tri(triangle, row + 1, col);
        int rightPath = tri(triangle, row + 1, col + 1);
        return dp[row][col] = triangle.get(row).get(col) + Math.min(leftPath, rightPath);
    }
}