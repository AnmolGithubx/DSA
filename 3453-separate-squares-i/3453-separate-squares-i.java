class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }

        for (int iter = 0; iter < 60; iter++) {
            double mid = (low + high) / 2.0;

            double below = 0, above = 0;

            for (int[] s : squares) {
                double bottom = s[1];
                double top = s[1] + s[2];
                double side = s[2];
                double totalArea = side * side;

                if (top <= mid) {
                    below += totalArea;
                } else if (bottom >= mid) {
                    above += totalArea;
                } else {
                    double heightBelow = mid - bottom;
                    double areaBelow = heightBelow * side;
                    below += areaBelow;
                    above += totalArea - areaBelow;
                }
            }

            if (below < above) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
