import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);
        for (int i = 0; i < 31; i++) {
            int power = 1 << i;
            if (target.equals(sortDigits(power))) {
                return true;
            }
        }
        return false;
    }

    private String sortDigits(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
