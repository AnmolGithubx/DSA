class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = getMaxGap(hBars);
        int maxV = getMaxGap(vBars);
        
        int side = Math.min(maxH, maxV);
        return side * side;
    }

    private int getMaxGap(int[] bars) {
        Arrays.sort(bars);
        int maxConsecutive = 1;
        int currentConsecutive = 1;
        
        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                currentConsecutive++;
            } else {
                currentConsecutive = 1;
            }
            maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
        }
        // A sequence of 'k' bars removed creates a gap of 'k + 1' units
        return maxConsecutive + 1;
    }
}