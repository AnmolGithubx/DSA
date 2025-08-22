class Solution {
    public int xorOperation(int n, int start) {
        int xorSum = 0;
        for(int i=0;i<n;i++){
            int num=start+2*i;
            xorSum ^= num;
        }
        return xorSum;
    }
}