class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rowSum = new int[m][n + 1];
        int[][] colSum = new int[n][m + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                colSum[j][i + 1] = colSum[j][i] + grid[i][j];
            }
        }

        for (int k = Math.min(m, n); k > 1; k--) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (isMagic(grid, i, j, k, rowSum, colSum)) return k;
                }
            }
        }
        return 1;
    }

    private boolean isMagic(int[][] grid, int r, int c, int k, int[][] rowSum, int[][] colSum) {
        int target = rowSum[r][c + k] - rowSum[r][c];
        
        // Check rows
        for (int i = r + 1; i < r + k; i++) {
            if (rowSum[i][c + k] - rowSum[i][c] != target) return false;
        }
        
        // Check columns
        for (int j = c; j < c + k; j++) {
            if (colSum[j][r + k] - colSum[j][r] != target) return false;
        }
        
        // Check main diagonal
        int d1 = 0;
        for (int i = 0; i < k; i++) d1 += grid[r + i][c + i];
        if (d1 != target) return false;
        
        // Check anti-diagonal
        int d2 = 0;
        for (int i = 0; i < k; i++) d2 += grid[r + i][c + k - 1 - i];
        return d2 == target;
    }
}