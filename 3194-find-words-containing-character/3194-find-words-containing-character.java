import java.util.*;

class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();         
        if (words == null) return res;

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (w != null && w.indexOf(x) != -1) {    
                res.add(i);
            }
        }
        return res;
    }
}
