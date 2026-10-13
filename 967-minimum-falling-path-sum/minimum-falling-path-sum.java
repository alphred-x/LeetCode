class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int up = matrix[row - 1][col];
                int upLeft = (col > 0) ? matrix[row - 1][col - 1] : Integer.MAX_VALUE;
                int upRight = (col < n - 1) ? matrix[row - 1][col + 1] : Integer.MAX_VALUE;
                matrix[row][col] += Math.min(up, Math.min(upLeft, upRight));
            }
        }
        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, matrix[n - 1][col]);
        }
        
        return minSum;
    }
}