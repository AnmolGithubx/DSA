class Solution {
    public int countHillValley(int[] nums) {
        // making the arraylist here to remove the duplicates
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
                temp.add(nums[i]);
            }
        }
        
        int count = 0;
        for (int i = 1; i < temp.size() - 1; i++) {
            // skip first and last element, because to check for hill/valley at index i, we need both i-1 and i+1
            int prev = temp.get(i - 1);
            int curr = temp.get(i);
            int next = temp.get(i + 1);

            if (curr > prev && curr > next) count++;
            if (curr < prev && curr < next) count++; 
        }

        return count;
    }
}