class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zeroCount = 0, maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // agar 1 se jyada zero ho gaye toh window shrink karo
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // abhi window valid hai (max 1 zero), length nikal lo
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // ek delete karna compulsory hai
        return maxLen - 1;
    }
}
