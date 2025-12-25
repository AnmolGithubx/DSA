class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1_000_000_007;

        // dp[i][j][rem] stores number of paths to (i, j) with sum % k == rem
        int[][][] dp = new int[m][n][k];

        // Initialize starting point
        dp[0][0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int rem = 0; rem < k; rem++) {
                    if (dp[i][j][rem] == 0) continue;

                    // Move Right
                    if (j + 1 < n) {
                        int nextRem = (rem + grid[i][j + 1]) % k;
                        dp[i][j + 1][nextRem] = (dp[i][j + 1][nextRem] + dp[i][j][rem]) % MOD;
                    }

                    // Move Down
                    if (i + 1 < m) {
                        int nextRem = (rem + grid[i + 1][j]) % k;
                        dp[i + 1][j][nextRem] = (dp[i + 1][j][nextRem] + dp[i][j][rem]) % MOD;
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}