class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        
        for (int num : nums) {
            int count = 0;
            int currentSum = 0;
            
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    // First divisor
                    count++;
                    currentSum += i;
                    
                    // Second divisor (if not a perfect square)
                    if (i * i != num) {
                        count++;
                        currentSum += num / i;
                    }
                }
                // Optimization: stop if we already have more than 4 divisors
                if (count > 4) break;
            }
            
            if (count == 4) {
                totalSum += currentSum;
            }
        }
        
        return totalSum;
    }
}