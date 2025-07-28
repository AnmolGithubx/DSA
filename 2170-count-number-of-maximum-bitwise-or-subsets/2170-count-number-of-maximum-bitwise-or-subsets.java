class Solution {
    int maxOr = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Find the maximum possible OR
        for (int num : nums) {
            maxOr |= num;
        }

        // Step 2: Start DFS/backtracking from index 0
        dfs(nums, 0, 0);

        return count;
    }

    void dfs(int[] nums, int index, int currOr) {
        if (index == nums.length) {
            if (currOr == maxOr) {
                count++;
            }
            return;
        }

        // Include current number
        dfs(nums, index + 1, currOr | nums[index]);

        // Exclude current number
        dfs(nums, index + 1, currOr);
    }
}
