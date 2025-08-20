class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int total = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (matrix[i][j] == 0) continue;
                int maxSize = Math.min(m - i, n - j);
                 for (int size = 1; size <= maxSize; size++) {
                    if (isAllOnes(matrix, i, j, size)) {
                        total++;
                    } else {
                        break;
                    }
                }
            }
        }
        return total;
    }
    private boolean isAllOnes(int[][] mat, int row, int col, int size) {
        int endRow = row + size - 1;
        int endCol = col + size - 1;

        for (int r = row; r <= endRow; r++) {
            for (int c = col; c <= endCol; c++) {
                if (mat[r][c] == 0) return false; 
            }
        }
        return true;
    }
}