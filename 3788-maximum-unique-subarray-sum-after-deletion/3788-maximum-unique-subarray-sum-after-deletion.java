class Solution {
    public int maxSum(int[] nums) {
        int mx = Arrays.stream(nums).max().getAsInt(); // converts the integer array nums into a stream of integers,,, .max() finds the maximum element in the stream,,,,.getAsInt() retrieves the maximum element as an int
        if (mx <= 0) {
            return mx;
        }
        boolean[] s = new boolean[201];
        int ans = 0;
        for (int x : nums) {
            if (x < 0 || s[x]) {
                continue;
            }
            ans += x;
            s[x] = true;
        }
        return ans;
    }
}
