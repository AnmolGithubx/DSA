class Solution {
    public int minimumSum(int[][] grid) {
        final int m = grid.length;
        final int n = grid[0].length;
        int ans = m * n;

        // Horizontal splits: top + left/right blocks
        for (int i = 0; i < m; ++i) {
            final int top = minimumArea(grid, 0, i, 0, n - 1);
            for (int j = 0; j < n; ++j) {
                ans = Math.min(ans,
                    top
                    + minimumArea(grid, i + 1, m - 1, 0, j)
                    + minimumArea(grid, i + 1, m - 1, j + 1, n - 1));
            }
        }

        // Bottom + left/right blocks
        for (int i = 0; i < m; ++i) {
            final int bottom = minimumArea(grid, i, m - 1, 0, n - 1);
            for (int j = 0; j < n; ++j) {
                ans = Math.min(ans,
                    bottom
                    + minimumArea(grid, 0, i - 1, 0, j)
                    + minimumArea(grid, 0, i - 1, j + 1, n - 1));
            }
        }

        // Vertical splits: left + top/bottom blocks
        for (int j = 0; j < n; ++j) {
            final int left = minimumArea(grid, 0, m - 1, 0, j);
            for (int i = 0; i < m; ++i) {
                ans = Math.min(ans,
                    left
                    + minimumArea(grid, 0, i, j + 1, n - 1)
                    + minimumArea(grid, i + 1, m - 1, j + 1, n - 1));
            }
        }

        // Vertical splits: right + top/bottom blocks
        for (int j = 0; j < n; ++j) {
            final int right = minimumArea(grid, 0, m - 1, j, n - 1);
            for (int i = 0; i < m; ++i) {
                ans = Math.min(ans,
                    right
                    + minimumArea(grid, 0, i, 0, j - 1)
                    + minimumArea(grid, i + 1, m - 1, 0, j - 1));
            }
        }

        // Three horizontal slices
        for (int i1 = 0; i1 < m; ++i1) {
            for (int i2 = i1 + 1; i2 < m; ++i2) {
                ans = Math.min(ans,
                    minimumArea(grid, 0, i1, 0, n - 1)
                    + minimumArea(grid, i1 + 1, i2, 0, n - 1)
                    + minimumArea(grid, i2 + 1, m - 1, 0, n - 1));
            }
        }

        // Three vertical slices
        for (int j1 = 0; j1 < n; ++j1) {
            for (int j2 = j1 + 1; j2 < n; ++j2) {
                ans = Math.min(ans,
                    minimumArea(grid, 0, m - 1, 0, j1)
                    + minimumArea(grid, 0, m - 1, j1 + 1, j2)
                    + minimumArea(grid, 0, m - 1, j2 + 1, n - 1));
            }
        }

        return ans;
    }

    // this fxn compute the area of the smallest axis-aligned rectangle that contains all 1s inside the subgrid defined by rows si..ei and columns sj..ej

    private int minimumArea(int[][] grid, int si, int ei, int sj, int ej) {
        int x1 = Integer.MAX_VALUE, y1 = Integer.MAX_VALUE;
        int x2 = -1, y2 = -1;
        for (int i = si; i <= ei; ++i) {
            for (int j = sj; j <= ej; ++j) {
                if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    x1 = Math.min(x1, i);
                    y1 = Math.min(y1, j);
                    x2 = Math.max(x2, i);
                    y2 = Math.max(y2, j);
                }
            }
        }
        return (x2 < x1 || y2 < y1) ? 0 : (x2 - x1 + 1) * (y2 - y1 + 1);
    }
}
