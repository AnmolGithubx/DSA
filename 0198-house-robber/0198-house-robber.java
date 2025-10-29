class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp=new int[n];
        Arrays.fill(dp, -1);
        return rec(nums, 0);        
    }
    public int rec(int[] nums, int idx){
        if(idx>=nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int rob = nums[idx]+rec(nums, idx+2);
        int skip=rec(nums, idx+1);
        dp[idx]=Math.max(rob,skip);
        return dp[idx];
    }
}