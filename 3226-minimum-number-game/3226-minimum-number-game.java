import java.util.*;
class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        int idx=0;
        for(int i=0;i<nums.length;i+=2){
            int alice=nums[i];
            int bob = nums[i+1];
            result[idx++] = bob;
            result[idx++] = alice;
        }
        return result;

    }
}