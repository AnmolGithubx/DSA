class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            int r = nums[i]%3;
            if(r!=0){
                count+=1;
            }
        }
        return count;
    }
}
