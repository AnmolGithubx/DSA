class Solution {
    static final int MOD = 1_000_000_007;
    Integer[][] dp;

    public int numberOfWays(int n, int x) {
        dp = new Integer[n + 1][n + 1];
        return dfs(n, 1, x);
    }

    private int dfs(int remaining, int current, int x) {
        if (remaining == 0) return 1; 
        if (remaining < 0 || Math.pow(current, x) > remaining) return 0; 

        if (dp[remaining][current] != null) return dp[remaining][current];

        int power = (int) Math.pow(current, x);

        int take = dfs(remaining - power, current + 1, x) % MOD;

        int skip = dfs(remaining, current + 1, x) % MOD;

        dp[remaining][current] = (take + skip) % MOD;
        return dp[remaining][current];
    }
}
