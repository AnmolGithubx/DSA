class Solution {
    public String mergeAlternately(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();

        StringBuilder mergedResult = new StringBuilder();

        for (int index = 0; index < word1Length || index < word2Length; index++) {
            if (index < word1Length) {
                mergedResult.append(word1.charAt(index));
            }
            if (index < word2Length) {
                mergedResult.append(word2.charAt(index));
            }
        }
        
        return mergedResult.toString();
    }
}