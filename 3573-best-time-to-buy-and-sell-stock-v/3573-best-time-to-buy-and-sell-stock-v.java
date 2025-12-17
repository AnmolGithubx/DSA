import java.util.Arrays;

class Solution {
    public long maximumProfit(int[] prices, int k) {
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }

        int n = prices.length;
        
        // Optimization: Max meaningful transactions is n/2 because each transaction
        // takes at least 2 days (open i, close j) + 1 day gap before next open.
        // Actually, since gap is required, minimal cycle is Open(i)->Close(i+1)->Gap(i+1)->Open(i+2).
        // However, standard limit n/2 is safe enough.
        if (k > n / 2) {
            k = n / 2;
        }

        // F[t]: Max profit with 't' transactions completed, currently Flat (no position)
        // L[t]: Max profit with 't' transactions completed, currently Long (holding stock)
        // S[t]: Max profit with 't' transactions completed, currently Short (shorted stock)
        long[] F = new long[k + 1];
        long[] L = new long[k + 1];
        long[] S = new long[k + 1];

        // Initialize with a sufficiently small number to represent impossible states
        long INF = Long.MIN_VALUE / 2;
        Arrays.fill(F, INF);
        Arrays.fill(L, INF);
        Arrays.fill(S, INF);

        // Base case: 0 transactions completed, 0 profit.
        F[0] = 0;

        for (int price : prices) {
            long[] nextF = F.clone();
            long[] nextL = L.clone();
            long[] nextS = S.clone();

            for (int t = 0; t <= k; t++) {
                // 1. Try to Close positions (Move into Flat state F[t])
                // To complete the 't'-th transaction, we must have been in L or S state
                // with 't-1' transactions completed.
                if (t > 0) {
                    // Close Long (Sell): Profit + price
                    nextF[t] = Math.max(nextF[t], L[t - 1] + price);
                    // Close Short (Buy back): Profit - price
                    nextF[t] = Math.max(nextF[t], S[t - 1] - price);
                }

                // 2. Try to Open positions (Move into L[t] or S[t])
                // We are working towards the (t+1)-th transaction, so we currently 
                // have 't' completed transactions.
                if (t < k) {
                    // Open Long (Buy): Pay price
                    nextL[t] = Math.max(nextL[t], F[t] - price);
                    // Open Short (Sell): Receive price
                    nextS[t] = Math.max(nextS[t], F[t] + price);
                }
            }

            // Update states for the next day
            F = nextF;
            L = nextL;
            S = nextS;
        }

        // The answer is the maximum profit in any Flat state.
        // (Usually F[k] is best, but due to "at most k", we check all).
        long maxProfit = 0;
        for (long profit : F) {
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}