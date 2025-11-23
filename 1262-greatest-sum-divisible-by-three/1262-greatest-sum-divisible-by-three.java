class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];

        for (int num : nums) {
            int[] temp = dp.clone();

            for (int r = 0; r < 3; r++) {
                int newSum = temp[r] + num;
                dp[newSum % 3] = Math.max(dp[newSum % 3], newSum);
            }
        }

        return dp[0];
    }
}
