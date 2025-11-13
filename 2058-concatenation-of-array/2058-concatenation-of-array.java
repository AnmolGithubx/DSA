class Solution {
    public int[] getConcatenation(int[] nums) {
        int aLen = nums.length;
        int[] result = new int[aLen + aLen];
        System.arraycopy(nums, 0, result, 0, aLen);
    
        System.arraycopy(nums, 0, result, aLen, aLen);
        return result;
    }
}