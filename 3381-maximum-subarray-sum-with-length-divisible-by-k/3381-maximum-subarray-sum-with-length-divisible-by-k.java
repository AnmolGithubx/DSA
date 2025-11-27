import java.util.Arrays;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        minPrefix[0] = 0;
        
        long currentSum = 0;
        long ans = Long.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int remainder = (i + 1) % k;
            if (minPrefix[remainder] != Long.MAX_VALUE) {
                long subarraySum = currentSum - minPrefix[remainder];
                ans = Math.max(ans, subarraySum);
            }
            minPrefix[remainder] = Math.min(minPrefix[remainder], currentSum);
        }
        return ans;
    }
}