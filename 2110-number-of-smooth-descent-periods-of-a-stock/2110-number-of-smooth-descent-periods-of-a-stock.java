class Solution {
    public long getDescentPeriods(int[] prices) {
        long total = 0;
        long length = 1;  // Every single day is a smooth descent period
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                // Continue the smooth descent
                length++;
            } else {
                // Smooth descent broke, add count for previous sequence
                total += length * (length + 1) / 2;
                // Start new sequence
                length = 1;
            }
        }
        
        // Don't forget the last sequence
        total += length * (length + 1) / 2;
        
        return total;
    }
}
