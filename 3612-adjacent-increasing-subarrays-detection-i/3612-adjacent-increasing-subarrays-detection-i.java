import java.util.*;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        int n = nums.size();
        if(2 * k > n) return false; 


        int increasing = 1;
        int previncreasing = 0;

        for(int i=1;i<nums.size();i++){
            if(nums.get(i) > nums.get(i-1)){
                ++increasing;
            } else {
                if (previncreasing >= k && increasing >= k) return true;
                previncreasing = increasing;
                increasing = 1;
            }
            if(increasing >= 2*k) return true;
            if(previncreasing >= k && increasing >= k) return true;
        }
        return false;
    }
}