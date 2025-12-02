class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] p : points){
            map.put(p[1],map.getOrDefault(p[1],0)+1);
        }

        List<Long> f = new ArrayList<>();
        for(int cnt : map.values()){
            long val = comb2(cnt);
            if(val>0) f.add(val);
        }
        if(f.size()<2) return 0;
        long ans = 0;
        long prefix=0;

        for(long x:f){
            ans = (ans+(x*prefix)%1_000_000_007)%1_000_000_007;
            prefix = (prefix+x)%1_000_000_007;
        } 
        return (int)ans;
    }

    private long comb2(long n){
        if(n<2) return 0;
        return (n*(n-1)/2)%1_000_000_007;
    }
}