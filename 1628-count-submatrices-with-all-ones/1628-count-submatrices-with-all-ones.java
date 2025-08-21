class Solution {
    public int numSubmat(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        for(int i=0;i<r;i++){
            for(int j=c-2;j>=0;j--){
                if(mat[i][j] == 1){
                    mat[i][j] +=  mat[i][j+1];
                }
            }
        }
        int count = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int min_width = mat[i][j];
                for(int d=i;d<r;d++){
                    if(mat[d][j]==0){
                        break;
                    }
                    min_width=Math.min(min_width,mat[d][j]);
                    count+=min_width;
                }
            }
        }
        return count;
    }
}