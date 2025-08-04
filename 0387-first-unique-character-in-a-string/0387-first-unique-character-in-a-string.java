class Solution {
    public int firstUniqChar(String s) {
        // Create an array to store the frequency of each character
        int[] charCounts = new int[26];
      
        // Get the length of the string for use in loops
        int stringLength = s.length();
      
        // Iterate over the string to count the frequency of each character
        for (int i = 0; i < stringLength; ++i) {
            charCounts[s.charAt(i) - 'a']++;
        }
      
        // Iterate over the string a second time to find the first unique character
        for (int i = 0; i < stringLength; ++i) {
            // If the count of the current character is 1, return its index
            if (charCounts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
      
        // If no unique character is found, return -1
        return -1;
    }
}