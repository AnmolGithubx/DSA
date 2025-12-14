class Solution {
    public int numberOfWays(String corridor) {
        long ans = 1;
        int seats = 0;
        int prevSeatIdx = -1;
        long mod = 1_000_000_007;

        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                seats++;
                
                // If this is the start of a new pair (3rd, 5th, 7th seat, etc.)
                // We calculate the number of ways to split the previous pair from this one.
                if (seats > 2 && seats % 2 != 0) {
                    long waysToPlaceDivider = i - prevSeatIdx;
                    ans = (ans * waysToPlaceDivider) % mod;
                }
                
                prevSeatIdx = i;
            }
        }

        // If there are no seats or an odd number of seats, no valid division exists.
        if (seats == 0 || seats % 2 != 0) {
            return 0;
        }

        return (int) ans;
    }
}