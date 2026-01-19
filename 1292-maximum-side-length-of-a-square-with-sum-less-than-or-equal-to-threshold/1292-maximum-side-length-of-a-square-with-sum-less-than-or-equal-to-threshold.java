class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] pref = new int[m + 1][n + 1];
        
        // Step 1: Build 2D Prefix Sum
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1] + pref[i - 1][j] + 
                             pref[i][j - 1] - pref[i - 1][j - 1];
            }
        }
        
        int ans = 0;
        // Step 2: Iterate and check if we can expand the square
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Only check if a square of size (ans + 1) is possible at this position
                int k = ans + 1;
                if (i >= k && j >= k) {
                    int sum = pref[i][j] - pref[i - k][j] - 
                              pref[i][j - k] + pref[i - k][j - k];
                    
                    if (sum <= threshold) {
                        ans++; // Found a larger square!
                    }
                }
            }
        }
        
        return ans;
    }
}