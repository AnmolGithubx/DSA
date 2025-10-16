class Solution {
    public int numIslands(char[][] grid) {
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};

    public void dfs(int i, int j , char[][] grid){
        grid[i][j] = '-';
        for(int[] dir : directions){
            int new_i = i+dir[0];
            int new_j = j+dir[1];

            if(isSafe(new_i, new_j, grid))
                dfs(new_i, new_j, grid);
        }
    }

    public boolean isSafe(int x, int y, char[][] grid){
        //out of bound condition
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length)
            return false;
        
        //viisited
        if(grid[x][y] == '-') return false;

        //water
        if(grid[x][y] == '0') return false;

        return true;
    }
}