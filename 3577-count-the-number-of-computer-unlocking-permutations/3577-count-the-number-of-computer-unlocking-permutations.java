class Solution {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        long rootComplexity = complexity[0];

        // 1. Check strict reachability constraint
        // Every unlocked computer must strictly have a higher complexity than the root (0).
        // If comp[i] <= comp[0], it can never be reached from 0 via a chain of increasing complexities.
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= rootComplexity) {
                return 0;
            }
        }

        // 2. Calculate Factorial
        // If the check passes, computer 0 can directly unlock ALL other computers.
        // Therefore, any relative ordering of the computers 1 to n-1 is valid 
        // because 0 (the root) is always present at the start.
        long ans = 1;
        long MOD = 1_000_000_007;

        for (int i = 1; i < n; i++) {
            ans = (ans * i) % MOD;
        }

        return (int) ans;
    }
}