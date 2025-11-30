class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum =0;
        for(int n : nums){
            sum+=n;
        }
        long target = sum%p;
        if(target==0) return 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L,-1);
        long prefix = 0;
        int minLen = nums.length;
        for(int i=0;i<nums.length;i++){
            prefix = (prefix+nums[i])%p;
            long need = (prefix-target+p)%p;
            if(map.containsKey(need)){
                minLen = Math.min(minLen, i-map.get(need));
            }
            map.put(prefix, i);
        }
        return minLen == nums.length?-1:minLen;
    }
}