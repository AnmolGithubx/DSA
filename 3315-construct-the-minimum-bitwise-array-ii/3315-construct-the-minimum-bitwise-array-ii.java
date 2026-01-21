import java.util.List;

class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int val = nums.get(i);
            
            if (val == 2) {
                ans[i] = -1;
            } else {
                int temp = val;
                int count = 0;
                while ((temp & 1) == 1) {
                    temp >>= 1;
                    count++;
                }
                ans[i] = val ^ (1 << (count - 1));
            }
        }
        
        return ans;
    }
}