import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> exactMatch = new HashSet<>();
        HashMap<String, String> caseInsensitiveMap = new HashMap<>();
        HashMap<String, String> vowelInsensitiveMap = new HashMap<>();

        for (String word : wordlist) {
            exactMatch.add(word);
            String lower = word.toLowerCase();
            if (!caseInsensitiveMap.containsKey(lower)) {
                caseInsensitiveMap.put(lower, word);
            }
            String deVoweled = devowel(lower);
            if (!vowelInsensitiveMap.containsKey(deVoweled)) {
                vowelInsensitiveMap.put(deVoweled, word);
            }
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            // Rule 1: Exact match
            if (exactMatch.contains(query)) {
                result[i] = query;
                continue;
            }

            String lower = query.toLowerCase();
            
            // Rule 2: Case-insensitive match
            if (caseInsensitiveMap.containsKey(lower)) {
                result[i] = caseInsensitiveMap.get(lower);
                continue;
            }

            // Rule 3: Vowel-insensitive match
            String deVoweled = devowel(lower);
            if (vowelInsensitiveMap.containsKey(deVoweled)) {
                result[i] = vowelInsensitiveMap.get(deVoweled);
                continue;
            }
            
            // No match found
            result[i] = "";
        }
        return result;
    }

    private String devowel(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(Character.toLowerCase(c)) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}