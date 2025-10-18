class Solution {
    // List to store all permutations
    private List<List<Integer>> result = new ArrayList<>();
    // Temporary list to build current permutation
    private List<Integer> currentPermutation = new ArrayList<>();
    // Boolean array to track which elements are already used in current permutation
    private boolean[] visited;
    // Reference to the input array
    private int[] numbers;

    /**
     * Generates all permutations of the given array
     * @param nums input array of distinct integers
     * @return list of all possible permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        this.numbers = nums;
        this.visited = new boolean[nums.length];
        backtrack(0);
        return result;
    }

    /**
     * Recursive backtracking function to generate permutations
     * @param depth current depth in the recursion tree (number of elements in current permutation)
     */
    private void backtrack(int depth) {
        // Base case: if we've added all elements, save the current permutation
        if (depth == numbers.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
      
        // Try adding each unused element to the current permutation
        for (int i = 0; i < numbers.length; i++) {
            // Skip if this element is already used in current permutation
            if (!visited[i]) {
                // Mark element as used
                visited[i] = true;
                // Add element to current permutation
                currentPermutation.add(numbers[i]);
              
                // Recursively build the rest of the permutation
                backtrack(depth + 1);
              
                // Backtrack: remove element and mark as unused
                currentPermutation.remove(currentPermutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}