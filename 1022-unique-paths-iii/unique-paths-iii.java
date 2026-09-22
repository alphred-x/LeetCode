class Solution {
    public int path(int i, int j, int[][] grid, int n, int m, int cnt) {
        if (i >= n || j >= m || i < 0 || j < 0 || grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 2) {
            return cnt == -1 ? 1 : 0;
        }
        int originalValue = grid[i][j];
        grid[i][j] = -1;
        int a = path(i + 1, j, grid, n, m, cnt - 1);
        int b = path(i, j + 1, grid, n, m, cnt - 1);
        int c = path(i - 1, j, grid, n, m, cnt - 1);
        int d = path(i, j - 1, grid, n, m, cnt - 1);

        grid[i][j] = originalValue;
        return a + b + c + d;
    }
    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        int cnt = 0;
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    cnt++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        ans = path(startX, startY, grid, n, m, cnt);
        return ans;
    }
}