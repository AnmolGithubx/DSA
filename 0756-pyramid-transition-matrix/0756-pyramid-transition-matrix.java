import java.util.*;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        
        return backtrack(bottom, "", map, new HashSet<>());
    }

    private boolean backtrack(String currentLevel, String nextLevel, Map<String, List<Character>> map, Set<String> memo) {
        // Base case: Reached the top of the pyramid
        if (currentLevel.length() == 1) {
            return true;
        }

        // If we finished building the next level, move up to it
        if (nextLevel.length() == currentLevel.length() - 1) {
            if (memo.contains(nextLevel)) return false;
            if (backtrack(nextLevel, "", map, memo)) return true;
            memo.add(nextLevel);
            return false;
        }

        // Get the pair of blocks from the current level to determine the block above them
        int i = nextLevel.length();
        String key = currentLevel.substring(i, i + 2);

        if (map.containsKey(key)) {
            for (char top : map.get(key)) {
                if (backtrack(currentLevel, nextLevel + top, map, memo)) {
                    return true;
                }
            }
        }

        return false;
    }
}