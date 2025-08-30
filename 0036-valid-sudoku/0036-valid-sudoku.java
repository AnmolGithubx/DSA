class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            boolean[] box = new boolean[9];

            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1'; // convert char to index (0-8)
                    if (row[num]) return false; // already seen
                    row[num] = true;
                }

                // Check column
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (col[num]) return false;
                    col[num] = true;
                }

                // Check 3x3 box
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                char current = board[rowIndex + j / 3][colIndex + j % 3];
                if (current != '.') {
                    int num = current - '1';
                    if (box[num]) return false;
                    box[num] = true;
                }
            }
        }
        return true;
    }
}