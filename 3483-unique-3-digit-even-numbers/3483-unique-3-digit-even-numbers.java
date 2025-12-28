import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }
        
        Set<Integer> result = new HashSet<>();
        generate(freq, 0, 0, result);
        return result.size();
    }

    private void generate(int[] freq, int currentNum, int length, Set<Integer> result) {
        if (length == 3) {
            if (currentNum % 2 == 0) {
                result.add(currentNum);
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (freq[i] > 0) {
                if (length == 0 && i == 0) {
                    continue;
                }

                freq[i]--;
                generate(freq, currentNum * 10 + i, length + 1, result);
                freq[i]++;
            }
        }
    }
}