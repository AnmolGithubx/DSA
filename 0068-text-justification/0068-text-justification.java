import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int numberOfWords = last - index;

            if (last == words.length || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i != last - 1) line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } 
            else {
                int totalSpaces = maxWidth - (totalChars - (numberOfWords - 1));
                int spaceBetween = totalSpaces / (numberOfWords - 1);
                int extraSpaces = totalSpaces % (numberOfWords - 1);

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i != last - 1) {
                        int spacesToApply = spaceBetween + (i - index < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }
}
