class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1)
            return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i <= n - k; i++) {
            int currentDiff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, currentDiff);
        }
        return minDiff;
    }
}