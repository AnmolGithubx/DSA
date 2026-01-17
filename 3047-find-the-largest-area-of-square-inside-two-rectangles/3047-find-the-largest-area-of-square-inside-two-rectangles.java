class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxSide = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Calculate the boundaries of the intersecting rectangle
                int intersectBottomX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int intersectBottomY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int intersectTopX = Math.min(topRight[i][0], topRight[j][0]);
                int intersectTopY = Math.min(topRight[i][1], topRight[j][1]);

                // Check if a valid intersection exists
                if (intersectTopX > intersectBottomX && intersectTopY > intersectBottomY) {
                    int width = intersectTopX - intersectBottomX;
                    int height = intersectTopY - intersectBottomY;

                    // The largest square in this overlap has side = min(width, height)
                    int side = Math.min(width, height);
                    maxSide = Math.max(maxSide, (long) side);
                }
            }
        }

        return maxSide * maxSide;
    }
}