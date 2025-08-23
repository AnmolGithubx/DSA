class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        //here we will take the product of all elements before the current index
        answer[0] = 1; 
        for (int i = 1; i < n; i++) { // 0 index de left ch kuj haini ess krke 1 tonh shuru krange
            answer[i] = answer[i - 1] * nums[i - 1]; // Yeh har element ke liye uske left side ke numbers ka product store kar raha hai.
        }

        //and here we will calcuate the product of all elements after the current index), and multiply it with the prefix result.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) { //Yeh loop right se left jaa raha hai: answer[i] ke andar already left ka product hai.Ab usme right ka product bhi multiply kar dete hain.
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }
}