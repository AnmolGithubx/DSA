class Solution {

    private void dfs(int row, int col, int[][] ans, int[][] image,int newColor, int[] delRow, int[] delCol, int iniColor) {

        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                if (image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
                    dfs(nrow, ncol, ans, image, newColor, delRow, delCol, iniColor);
                }
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int iniColor = image[sr][sc];

        if (iniColor == newColor)
            return image;

        int[][] ans = new int[image.length][image[0].length];

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                ans[i][j] = image[i][j];
            }
        }

        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1};

        dfs(sr, sc, ans, image, newColor, delRow, delCol, iniColor);
        return ans;
    }
}
