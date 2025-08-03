import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int index, 
                           List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            // Found a valid combination
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index == candidates.length) {
            // Invalid path
            return;
        }

        // Include the current element
        current.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, current, result); // not index + 1 because we can reuse
        current.remove(current.size() - 1); // backtrack

        // Exclude the current element and move to next
        backtrack(candidates, target, index + 1, current, result);
    }
}
