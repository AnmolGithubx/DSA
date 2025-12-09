class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int mod = 1000000007;
        Map<Integer, Long> rightfreq = new HashMap<>();
        Map<Integer, Long> leftfreq = new HashMap<>();
        for(int x:nums){
            rightfreq.put(x,rightfreq.getOrDefault(x,0L)+1);
        }
        long ans = 0;
        for(int j=0;j<n;j++){
            rightfreq.put(nums[j],rightfreq.get(nums[j])-1);
            long target = (long) nums[j]*2;
            long left = leftfreq.getOrDefault((int) target, 0L);
            long right = rightfreq.getOrDefault((int) target, 0L);

            ans = (ans+(left*right)%mod)%mod;
            leftfreq.put(nums[j],leftfreq.getOrDefault(nums[j], 0L)+1);
        }
        return (int) ans;

        // for (int j = 0; j < n - 1; j++) {
        //     long left = 0;
        //     long right = 0;
        //     long target = (long) nums[j] * 2;

        //     for (int i = 0; i < j; i++) {
        //         if (nums[i] == target) {
        //             left++;
        //         }
        //     }

        //     for (int k = j+1; k < n; k++) {
        //         if (nums[k] == target) {
        //             right++;
        //         }
        //     }

        //     if (left > 0 && right > 0) {
        //         count = (count + (left * right)) % mod;
        //     }
        // }
        // return (int) count;
    }
}