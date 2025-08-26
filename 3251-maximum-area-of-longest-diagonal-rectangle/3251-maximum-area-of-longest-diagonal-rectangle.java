class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0;
        int maxArea = 0;
        
        for (int i = 0; i < dimensions.length; i++) {
            int w = dimensions[i][0];
            int h = dimensions[i][1];

            int diagonalSq = w * w + h * h;
            int area = w * h;

            if (diagonalSq > maxDiagonal) {
                maxDiagonal = diagonalSq;
                maxArea = area;
            } else if (diagonalSq == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
