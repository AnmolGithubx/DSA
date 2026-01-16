import java.util.*;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long mod = 1_000_000_007;
        
        // Helper to get all possible distances between any two fences
        Set<Integer> hGaps = getGaps(m, hFences);
        Set<Integer> vGaps = getGaps(n, vFences);
        
        long maxSide = -1;
        
        // Find the maximum gap present in both sets
        for (int gap : hGaps) {
            if (vGaps.contains(gap)) {
                maxSide = Math.max(maxSide, gap);
            }
        }
        
        if (maxSide == -1) return -1;
        return (int) ((maxSide * maxSide) % mod);
    }
    
    private Set<Integer> getGaps(int limit, int[] fences) {
        List<Integer> f = new ArrayList<>();
        for (int fence : fences) f.add(fence);
        f.add(1);
        f.add(limit);
        Collections.sort(f);
        
        Set<Integer> gaps = new HashSet<>();
        for (int i = 0; i < f.size(); i++) {
            for (int j = i + 1; j < f.size(); j++) {
                gaps.add(f.get(j) - f.get(i));
            }
        }
        return gaps;
    }
}