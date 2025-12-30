class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i <= rows - 3; i++) {
            for (int j = 0; j <= cols - 3; j++) {
                if (isMagic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagic(int[][] grid, int r, int c) {
        // Optimization: The center of a 3x3 magic square of 1-9 must be 5
        if (grid[r + 1][c + 1] != 5) return false;

        int[] count = new int[16];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9 || ++count[val] > 1) return false;
            }
        }

        // Check rows
        if (grid[r][c] + grid[r][c+1] + grid[r][c+2] != 15) return false;
        if (grid[r+1][c] + grid[r+1][c+1] + grid[r+1][c+2] != 15) return false;
        if (grid[r+2][c] + grid[r+2][c+1] + grid[r+2][c+2] != 15) return false;

        // Check columns
        if (grid[r][c] + grid[r+1][c] + grid[r+2][c] != 15) return false;
        if (grid[r][c+1] + grid[r+1][c+1] + grid[r+2][c+1] != 15) return false;
        if (grid[r][c+2] + grid[r+1][c+2] + grid[r+2][c+2] != 15) return false;

        // Check diagonals
        if (grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2] != 15) return false;
        if (grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c] != 15) return false;

        return true;
    }
}