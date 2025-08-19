class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long s = 0;
        long count = 0;
        for(int num : nums){
            if(num==0){
                s++;
                count+=s;
            } else {
                s=0;
            }
        }
        return count;
    }
}