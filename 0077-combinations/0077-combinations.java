class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        rec(1,n,k,curr,ans);
        return ans;
    }
    public static void rec(int i, int n, int k, List<Integer> curr, List<List<Integer>> ans){
        if(curr.size()==k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(i>n) return;

        curr.add(i);

        rec(i+1, n,k,curr,ans);

        curr.remove(curr.size()-1);

        rec(i+1, n, k, curr, ans);
    }
}