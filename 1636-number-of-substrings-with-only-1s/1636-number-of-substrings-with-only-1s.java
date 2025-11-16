class Solution {
    public int numSub(String s) {
        long totalCount = 0;
        long currentCount = 0;
        int MOD = 1_000_000_007;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                currentCount++;
            }
            else {
                currentCount=0;
            }
            totalCount = (totalCount+currentCount)%MOD;
        }
        return (int)totalCount;
    }
}