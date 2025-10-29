class Solution {
    public int smallestNumber(int n) {
        return (1<<bitlength(n)) -1;
    }
    private int bitlength(int n){
        return Integer.SIZE - Integer.numberOfLeadingZeros(n);
    }
}