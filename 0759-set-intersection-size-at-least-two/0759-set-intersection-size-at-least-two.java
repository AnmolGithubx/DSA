import java.util.Arrays;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });

        int last = -1; 
        int secondLast = -1;
        int totalPicks = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            boolean lastIn = (last >= start && last <= end);
            boolean secondLastIn = (secondLast >= start && secondLast <= end);

            if (lastIn && secondLastIn) {
                continue;
            } 
            
            else if (lastIn) {
                totalPicks++;
                secondLast = last;
                last = end; 
            } 
            
            else {
                totalPicks += 2;
                secondLast = end - 1;
                last = end;
            }
        }

        return totalPicks;
    }
}