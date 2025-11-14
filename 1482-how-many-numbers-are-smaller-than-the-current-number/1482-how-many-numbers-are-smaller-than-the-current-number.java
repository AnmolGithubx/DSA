class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] newArr = new int[n];

        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(j!=i && nums[j]<nums[i]){
                    count++;
                }
            }
            newArr[i]=count;
        }
        return newArr;
    }
}