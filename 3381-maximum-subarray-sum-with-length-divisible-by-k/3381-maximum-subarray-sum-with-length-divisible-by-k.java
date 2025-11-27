import java.util.Arrays;

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        // minPrefix[r] stores the minimum prefix sum encountered so far 
        // at an index where (index + 1) % k == r
        long[] minPrefix = new long[k];
        
        // Initialize with infinity because we haven't seen these remainders yet
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        
        // Base case: A prefix of length 0 has sum 0.
        // 0 length % k is 0, so at index 0 we put sum 0.
        minPrefix[0] = 0;
        
        long currentSum = 0;
        long ans = Long.MIN_VALUE; // Initialize with smallest possible number
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            
            // Calculate remainder for the current length (i + 1)
            int remainder = (i + 1) % k;
            
            // If we have seen this remainder before, we can form a valid subarray
            if (minPrefix[remainder] != Long.MAX_VALUE) {
                long subarraySum = currentSum - minPrefix[remainder];
                ans = Math.max(ans, subarraySum);
            }
            
            // Update the minimum prefix sum for this remainder
            minPrefix[remainder] = Math.min(minPrefix[remainder], currentSum);
        }
        
        // If no valid subarray is found (rare edge case), returning 0 or checking logic depends on constraints
        // But typically for this problem, ans will be updated.
        return ans;
    }
}