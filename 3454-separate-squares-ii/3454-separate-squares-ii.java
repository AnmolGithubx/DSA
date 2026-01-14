import java.util.*;

class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        // Collect all unique Y coordinates to define horizontal strips
        TreeSet<Integer> ySet = new TreeSet<>();
        for (int[] s : squares) {
            ySet.add(s[1]);
            ySet.add(s[1] + s[2]);
        }
        List<Integer> distinctY = new ArrayList<>(ySet);
        int m = distinctY.size();
        
        // Map Y intervals to events (start/end of squares on the X-axis)
        // This is the "Sweep Line" moving along the Y-axis
        List<int[]>[] eventsAtY = new ArrayList[m];
        for (int i = 0; i < m; i++) eventsAtY[i] = new ArrayList<>();
        
        Map<Integer, Integer> yToIdx = new HashMap<>();
        for (int i = 0; i < m; i++) yToIdx.put(distinctY.get(i), i);
        
        for (int[] s : squares) {
            int y1 = yToIdx.get(s[1]);
            int y2 = yToIdx.get(s[1] + s[2]);
            // Square contributes to all strips between its bottom and top
            for (int i = y1; i < y2; i++) {
                eventsAtY[i].add(new int[]{s[0], 1}); // Start x
                eventsAtY[i].add(new int[]{s[0] + s[2], -1}); // End x
            }
        }

        double totalArea = 0;
        double[] stripAreas = new double[m - 1];

        // For each horizontal strip, calculate the union of x-segments
        for (int i = 0; i < m - 1; i++) {
            List<int[]> xEvents = eventsAtY[i];
            Collections.sort(xEvents, (a, b) -> a[0] - b[0]);
            
            long currentXUnion = 0;
            int count = 0;
            int lastX = 0;
            for (int[] e : xEvents) {
                if (count > 0) currentXUnion += (e[0] - lastX);
                count += e[1];
                lastX = e[0];
            }
            stripAreas[i] = currentXUnion * (double)(distinctY.get(i + 1) - distinctY.get(i));
            totalArea += stripAreas[i];
        }

        // Find the strip where the cumulative area reaches half of totalArea
        double target = totalArea / 2.0;
        double currentSum = 0;
        for (int i = 0; i < m - 1; i++) {
            if (currentSum + stripAreas[i] >= target - 1e-9) {
                // The line is inside this strip [distinctY[i], distinctY[i+1]]
                double remainingAreaNeeded = target - currentSum;
                double stripHeight = distinctY.get(i + 1) - distinctY.get(i);
                double stripWidth = stripAreas[i] / stripHeight;
                return distinctY.get(i) + (remainingAreaNeeded / stripWidth);
            }
            currentSum += stripAreas[i];
        }

        return distinctY.get(m - 1);
    }
}