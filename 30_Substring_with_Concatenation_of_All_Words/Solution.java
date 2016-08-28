/*
30. Substring with Concatenation of All Words  QuestionEditorial Solution  My Submissions
Total Accepted: 61070
Total Submissions: 286658
Difficulty: Hard
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).

Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (words == null || words.length == 0 || s == null || s.length() == 0) {
            return result;
        } 
        
        int wordLen = words[0].length();
        int count = words.length;
        if (s.length() < wordLen * count) {
            return result;
        }
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        
        for (int i = wordLen * count; i <= s.length(); i++) {
            String str = s.substring(i - wordLen * count, i);
            if (isValid(str, map, wordLen)) {
                result.add(i - wordLen * count);
            }
        }
        
        return result;
    }
    
    private boolean isValid(String str, HashMap<String, Integer> origin, int len) {
        HashMap<String, Integer> map = new HashMap<String, Integer>(origin);
        for (int i = 0; i < str.length() / len; i++) {
            String sub = str.substring(i * len, (i + 1) * len);
            if (map.containsKey(sub)) {
                map.put(sub, map.get(sub) - 1);
                if (map.get(sub) == 0) {
                    map.remove(sub);
                }
            } else {
                return false;
            }
        }
        
        return true;
    }
}