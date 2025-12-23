import java.util.Arrays;

class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        
        // Sort events by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Suffix maximum array: maxValues[i] is the max value from index i to n-1
        int[] maxValues = new int[n];
        maxValues[n - 1] = events[n - 1][2];
        for (int i = n - 2; i >= 0; i--) {
            maxValues[i] = Math.max(events[i][2], maxValues[i + 1]);
        }
        
        int maxSum = 0;
        
        for (int i = 0; i < n; i++) {
            // Option 1: Just attend this one event
            maxSum = Math.max(maxSum, events[i][2]);
            
            // Option 2: Attend this event and the best possible non-overlapping event after it
            int nextEventIdx = findNext(events, events[i][1], i + 1);
            if (nextEventIdx != -1) {
                maxSum = Math.max(maxSum, events[i][2] + maxValues[nextEventIdx]);
            }
        }
        
        return maxSum;
    }
    
    // Binary search for the first event starting at or after (targetEndTime + 1)
    private int findNext(int[][] events, int targetEndTime, int left) {
        int right = events.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > targetEndTime) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}