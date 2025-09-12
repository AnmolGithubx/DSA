class Solution {
    public boolean doesAliceWin(String s) {
        String lowerCaseString = s.toLowerCase();
        
        for (char c : lowerCaseString.toCharArray()) {

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }
        return false;
    }
}