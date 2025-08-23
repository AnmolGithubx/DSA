class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        //here we will take the product of all elements before the current index
        answer[0] = 1;
        for (int i = 1; i < n; i++) { 
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        //and here we will calcuate the product of all elements after the current index), and multiply it with the prefix result.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }
}