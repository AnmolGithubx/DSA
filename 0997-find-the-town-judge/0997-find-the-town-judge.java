class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n+1];

        for(int[] t : trust){
            int peopleTrusting = t[0];
            int peopleTrusted = t[1];

            count[peopleTrusting]--;
            count[peopleTrusted]++;
        }
        for(int i=1;i<=n;i++){
            if(count[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}