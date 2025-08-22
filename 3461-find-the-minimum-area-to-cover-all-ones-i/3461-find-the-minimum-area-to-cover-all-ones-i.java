class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minRow = m, maxRow = -1;
        int minCol = n, maxCol = -1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if (i < minRow) minRow = i;
                    if (i > maxRow) maxRow = i;
                    if (j < minCol) minCol = j;
                    if (j > maxCol) maxCol = j;
                }
            }
        }
        if(maxRow==-1) return 0;

        int a = (maxRow - minRow + 1); 
        int b = (maxCol - minCol + 1);

        return a*b;
    }
}