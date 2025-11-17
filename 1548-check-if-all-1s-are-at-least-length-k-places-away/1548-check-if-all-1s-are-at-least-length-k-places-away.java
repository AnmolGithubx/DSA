class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int l =-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                if(l!=-1){
                    int zero = i-l-1;
                    if(zero<k){
                        return false;
                    }
                }
                l=i;
            }
        }
        return true;
    }
}