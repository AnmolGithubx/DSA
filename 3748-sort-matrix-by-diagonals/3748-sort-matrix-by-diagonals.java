import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Process diagonals starting from the first column (i.e., bottom-left and main diagonals)
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> diagonal = new ArrayList<>();
            int row = i;
            int col = 0;
            // Extract the diagonal elements
            while (row < n && col < n) {
                diagonal.add(grid[row][col]);
                row++;
                col++;
            }
            
            // Sort in non-increasing order
            Collections.sort(diagonal, Collections.reverseOrder());

            // Re-populate the matrix
            row = i;
            col = 0;
            int k = 0;
            while (row < n && col < n) {
                grid[row][col] = diagonal.get(k);
                row++;
                col++;
                k++;
            }
        }

        // Process diagonals starting from the first row (i.e., top-right diagonals)
        for (int j = 1; j < n; j++) {
            ArrayList<Integer> diagonal = new ArrayList<>();
            int row = 0;
            int col = j;
            // Extract the diagonal elements
            while (row < n && col < n) {
                diagonal.add(grid[row][col]);
                row++;
                col++;
            }
            
            // Sort in non-decreasing order
            Collections.sort(diagonal);

            // Re-populate the matrix
            row = 0;
            col = j;
            int k = 0;
            while (row < n && col < n) {
                grid[row][col] = diagonal.get(k);
                row++;
                col++;
                k++;
            }
        }
        return grid;
    }
}