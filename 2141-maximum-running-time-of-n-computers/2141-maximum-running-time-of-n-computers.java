class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum=0;
        for(int b:batteries) sum+=b;

        long low = 0, high=sum/n;
        long ans=0;

        while(low<=high){
            long mid = low+(high-low)/2;
            if(canrun(n,batteries,mid)){
                ans=mid;
                low=mid+1;
            } else {
                high=mid-1;
            }
        }
        return ans;
    }
    private boolean canrun(int n, int[] batteries, long T){
        long usable = 0;
        for(int b:batteries){
            usable+=Math.min(b,T);
        }
        return usable >= (long)n*T;
    }
}