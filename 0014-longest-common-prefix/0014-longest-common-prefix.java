class Solution {
    public String longestCommonPrefix(String[] strs) {
        int numberOfStrings = strs.length;
        for (int index = 0; index < strs[0].length(); ++index){
            for (int stringIndex = 1; stringIndex < numberOfStrings; ++stringIndex){
                if (strs[stringIndex].length() <= index || strs[stringIndex].charAt(index) != strs[0].charAt(index)) {
                    return strs[0].substring(0, index);
                }
            }
        }
        return strs[0];
    }
}