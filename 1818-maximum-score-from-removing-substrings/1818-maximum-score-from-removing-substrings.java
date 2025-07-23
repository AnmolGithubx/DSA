class Solution {
    public int maximumGain(String s, int x, int y) {
        // Decide priority
        char firstA, firstB;
        int firstPoints, secondPoints;

        if (x > y) {
            firstA = 'a'; firstB = 'b';
            firstPoints = x; secondPoints = y;
        } else {
            firstA = 'b'; firstB = 'a';
            firstPoints = y; secondPoints = x;
        }

        // Step 1: Remove high priority pattern
        int total = 0;
        StringBuilder remaining = new StringBuilder();
        total += removePattern(s, firstA, firstB, firstPoints, remaining);

        // Step 2: Remove second pattern from remaining string
        StringBuilder dummy = new StringBuilder();
        total += removePattern(remaining.toString(), secondA(firstA, firstB), secondB(firstA, firstB), secondPoints, dummy);

        return total;
    }

    // Utility to remove pattern like "ab" or "ba"
    private int removePattern(String s, char a, char b, int point, StringBuilder outRemaining) {
        int score = 0;
        Stack<Character> temp = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!temp.isEmpty() && temp.peek() == a && ch == b) {
                temp.pop();
                score += point;
            } else {
                temp.push(ch);
            }
        }

        // convert stack to string
        for (char c : temp) outRemaining.append(c);
        return score;
    }

    // Utility to get second pattern
    private char secondA(char a, char b) {
        return b;
    }

    private char secondB(char a, char b) {
        return a;
    }
}
