class Solution {
    public int compress(char[] chars) {
        int writeIndex = 0, readIndex = 0;
        while (readIndex < chars.length) {
            char currentChar = chars[readIndex];
            int count = 0;
            while (readIndex < chars.length && chars[readIndex] == currentChar) {
                readIndex++;
                count++;
            }
            chars[writeIndex++] = currentChar;
            if (count > 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[writeIndex++] = digit;
                }
            }
        }
        return writeIndex;
    }
}