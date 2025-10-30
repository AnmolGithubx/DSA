class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        rec(nums, 0, curr, result);
        return result;
    }
    public static void rec(int[] nums, int start, List<Integer> curr, List<List<Integer>> result){
        result.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            curr.add(nums[i]);
            rec(nums, i+1, curr, result);
            curr.remove(curr.size()-1);
        }
    }
}