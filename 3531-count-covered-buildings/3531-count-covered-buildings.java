import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, Integer> rowMinCol = new HashMap<>();
        Map<Integer, Integer> rowMaxCol = new HashMap<>();
        Map<Integer, Integer> colMinRow = new HashMap<>();
        Map<Integer, Integer> colMaxRow = new HashMap<>();

        for (int[] b : buildings) {
            int r = b[0];
            int c = b[1];

            rowMinCol.put(r, Math.min(rowMinCol.getOrDefault(r, Integer.MAX_VALUE), c));
            rowMaxCol.put(r, Math.max(rowMaxCol.getOrDefault(r, Integer.MIN_VALUE), c));

            colMinRow.put(c, Math.min(colMinRow.getOrDefault(c, Integer.MAX_VALUE), r));
            colMaxRow.put(c, Math.max(colMaxRow.getOrDefault(c, Integer.MIN_VALUE), r));
        }

        int count = 0;

        for (int[] b : buildings) {
            int r = b[0];
            int c = b[1];

            boolean horizontalCover = rowMinCol.get(r) < c && rowMaxCol.get(r) > c;
            boolean verticalCover = colMinRow.get(c) < r && colMaxRow.get(c) > r;

            if (horizontalCover && verticalCover) {
                count++;
            }
        }
        
        return count;
    }
}