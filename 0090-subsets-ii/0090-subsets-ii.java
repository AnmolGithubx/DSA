class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public void solve(int index, int[] arr, List<Integer> a, List<List<Integer>> ans){
        if(index == arr.length){
            ans.add(new ArrayList<>(a));
            return;
        }
        a.add(arr[index]);
        solve(index+1, arr, a, ans);
        a.remove(a.size()-1);

        int nextIndex = index+1;
        while(nextIndex < arr.length && arr[nextIndex] == arr[index]){
            nextIndex++;
        }
        solve(nextIndex, arr, a, ans);
    }
}