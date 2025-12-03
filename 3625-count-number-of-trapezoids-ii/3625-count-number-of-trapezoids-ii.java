import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        if (n < 4) return 0;

        // Map 1: Group by Slope -> (Intercept -> Count)
        // Used to count total potential trapezoids based on parallel sides
        Map<String, Map<Long, Integer>> slopeMap = new HashMap<>();

        // Map 2: Group by Midpoint -> (Slope -> Count)
        // Used to count parallelograms to subtract duplicates
        Map<String, Map<String, Integer>> midMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];

                // Normalize Slope using GCD
                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g;
                dy /= g;

                // Standardize direction to ensure uniqueness (e.g., 1/1 is same as -1/-1)
                if (dx < 0 || (dx == 0 && dy < 0)) {
                    dx = -dx;
                    dy = -dy;
                }
                String slopeKey = dx + "," + dy;

                // --- 1. Handle Slope & Intercept Logic ---
                // Equation: -dy*x + dx*y = C. C is the intercept identifier.
                // We use long to prevent overflow during multiplication
                long intercept = (long) dx * points[i][1] - (long) dy * points[i][0];

                slopeMap.putIfAbsent(slopeKey, new HashMap<>());
                Map<Long, Integer> interceptMap = slopeMap.get(slopeKey);
                interceptMap.put(intercept, interceptMap.getOrDefault(intercept, 0) + 1);

                // --- 2. Handle Midpoint Logic ---
                // Midpoint * 2 = (x1+x2, y1+y2). We don't need to divide by 2 for the key.
                long midX = (long) points[i][0] + points[j][0];
                long midY = (long) points[i][1] + points[j][1];
                String midKey = midX + "," + midY;

                midMap.putIfAbsent(midKey, new HashMap<>());
                Map<String, Integer> midSlopeMap = midMap.get(midKey);
                midSlopeMap.put(slopeKey, midSlopeMap.getOrDefault(slopeKey, 0) + 1);
            }
        }

        long totalTrapezoids = 0;

        // Calculate Trapezoids based on Parallel Sides
        for (Map<Long, Integer> lines : slopeMap.values()) {
            long totalSegmentsWithSameSlope = 0;
            long collinearPairs = 0;

            for (int count : lines.values()) {
                totalSegmentsWithSameSlope += count;
                // Subtract pairs that are on the same line (collinear)
                collinearPairs += (long) count * (count - 1) / 2;
            }

            long allPairs = totalSegmentsWithSameSlope * (totalSegmentsWithSameSlope - 1) / 2;
            totalTrapezoids += (allPairs - collinearPairs);
        }

        long totalParallelograms = 0;

        // Calculate Parallelograms (Diagonals bisect each other)
        for (Map<String, Integer> slopesAtMid : midMap.values()) {
            long totalSegmentsAtMid = 0;
            long sameSlopePairs = 0;

            for (int count : slopesAtMid.values()) {
                totalSegmentsAtMid += count;
                // If two segments share a midpoint AND a slope, they are collinear 
                // (degenerate parallelogram), so we exclude them.
                sameSlopePairs += (long) count * (count - 1) / 2;
            }

            long allPairs = totalSegmentsAtMid * (totalSegmentsAtMid - 1) / 2;
            totalParallelograms += (allPairs - sameSlopePairs);
        }

        // Result is Parallel_Groups - Double_Counted_Parallelograms
        return (int) (totalTrapezoids - totalParallelograms);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}