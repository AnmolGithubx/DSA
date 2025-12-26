class Solution {
    public int bestClosingTime(String customers) {
        int minPenalty = 0;
        int currentPenalty = 0;
        int bestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                currentPenalty--;
            } else {
                currentPenalty++;
            }

            // If we found a new minimum penalty, update the best hour
            if (currentPenalty < minPenalty) {
                minPenalty = currentPenalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}