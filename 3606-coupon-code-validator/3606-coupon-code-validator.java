import java.util.*;

class Solution {
    // Helper class to hold data needed for sorting
    private static class ValidCoupon {
        String code;
        int priority;

        ValidCoupon(String code, int priority) {
            this.code = code;
            this.priority = priority;
        }
    }

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<ValidCoupon> validList = new ArrayList<>();
        int n = code.length;

        for (int i = 0; i < n; i++) {
            // 1. Check if active
            if (!isActive[i]) continue;

            // 2. Check business line and assign priority
            int priority = getBusinessPriority(businessLine[i]);
            if (priority == -1) continue; // Invalid category

            // 3. Check code format
            if (isValidFormat(code[i])) {
                validList.add(new ValidCoupon(code[i], priority));
            }
        }

        // 4. Sort based on priority first, then lexicographically by code
        Collections.sort(validList, (a, b) -> {
            if (a.priority != b.priority) {
                return Integer.compare(a.priority, b.priority);
            }
            return a.code.compareTo(b.code);
        });

        // 5. Extract only the codes for the result
        List<String> result = new ArrayList<>();
        for (ValidCoupon vc : validList) {
            result.add(vc.code);
        }
        
        return result;
    }

    // Helper to validate code string format
    private boolean isValidFormat(String s) {
        if (s == null || s.isEmpty()) return false;
        
        for (char c : s.toCharArray()) {
            // Must be a-z, A-Z, 0-9, or underscore
            if (!Character.isLetterOrDigit(c) && c != '_') {
                return false;
            }
        }
        return true;
    }

    // Helper to map business lines to sort order integers
    private int getBusinessPriority(String line) {
        switch (line) {
            case "electronics": return 0;
            case "grocery": return 1;
            case "pharmacy": return 2;
            case "restaurant": return 3;
            default: return -1; // Indicates invalid business line
        }
    }
}