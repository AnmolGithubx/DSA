import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < k; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i <= n - k; i++) {
            List<int[]> pairs = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                pairs.add(new int[]{entry.getKey(), entry.getValue()});
            }

            pairs.sort((a, b) -> {
                if (b[1] == a[1]) return b[0] - a[0];
                return b[1] - a[1];
            });

            int xSum = 0;
            for (int j = 0; j < Math.min(x, pairs.size()); j++) {
                xSum += pairs.get(j)[0] * pairs.get(j)[1];
            }

            result[i] = xSum;

            if (i + k < n) {
                int outNum = nums[i];
                int inNum = nums[i + k];

                freq.put(outNum, freq.get(outNum) - 1);
                if (freq.get(outNum) == 0) freq.remove(outNum);

                freq.put(inNum, freq.getOrDefault(inNum, 0) + 1);
            }
        }

        return result;
    }
}
