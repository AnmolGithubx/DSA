import java.util.Arrays;

class Solution {
    public int[] findErrorNums(int[] nums) {
        // Your idea: Sort the array first
        Arrays.sort(nums);
        
        int n = nums.length;
        int duplicate = -1;
        
        // Use 'long' to be safe, though 'int' is fine for these constraints
        long actualSum = 0;
        
        // This is the array we will return
        // We only need size 2: [duplicate, missing]
        int[] result = new int[2];
        
        // --- Step 1: Loop to find duplicate and actual sum ---
        for (int i = 0; i < n; i++) {
            
            // Add the number to our sum
            actualSum += nums[i];
            
            // Find the duplicate (using i > 0 is safer than i+1)
            if (i > 0 && nums[i] == nums[i - 1]) {
                duplicate = nums[i];
                result[0] = duplicate; // Put the duplicate in our answer array
            }
        }
        
        // --- Step 2: Use Math to find the missing number ---
        
        // Calculate the sum that *should* be there (sum of 1 to n)
        // Formula is n * (n + 1) / 2
        long expectedSum = (long) n * (n + 1) / 2;
        
        // The logic is:
        // actualSum = expectedSum - missing + duplicate
        // So, solving for 'missing':
        // missing = expectedSum - actualSum + duplicate
        
        int missing = (int) (expectedSum - actualSum + duplicate);
        
        result[1] = missing; // Put the missing number in our answer array
        
        return result;
    }
}