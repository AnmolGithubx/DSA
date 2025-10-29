class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return rec(n);
    }
    public int rec(int remaining){
        if(remaining == 0) return 1;
        if(remaining == -1) return 0;
        if(dp[remaining] != -1) return dp[remaining];

        int one_step = rec(remaining-1);
        int two_step = rec(remaining-2);
        dp[remaining] = one_step + two_step;
        return one_step+two_step;
    }
}