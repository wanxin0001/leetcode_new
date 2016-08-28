/*
291. Word Pattern II  QuestionEditorial Solution  My Submissions
Total Accepted: 7352
Total Submissions: 20393
Difficulty: Hard
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
Notes:
You may assume both pattern and str contains only lowercase letters.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
/*
Reference: https://discuss.leetcode.com/topic/26819/20-lines-java-clean-solution-easy-to-understand
*/
public class Solution {
    Map<Character, String> map = new HashMap<Character, String>();
    Set<String> set = new HashSet();
    
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.isEmpty()) {
            return str.isEmpty();
        }
        
        if (map.containsKey(pattern.charAt(0))) {
            String val = map.get(pattern.charAt(0));
            if (str.length() < val.length() || !str.substring(0, val.length()).equals(val)) {
                return false;
            }
            
            return wordPatternMatch(pattern.substring(1), str.substring(val.length()));
        } else {
            for (int i = 1; i <= str.length(); i++) {
                if (set.contains(str.substring(0, i))) {
                    continue;
                }
                
                map.put(pattern.charAt(0), str.substring(0, i));
                set.add(str.substring(0, i));
                if (wordPatternMatch(pattern.substring(1), str.substring(i))) {
                    return true;
                }
                set.remove(str.substring(0, i));
                map.remove(pattern.charAt(0));
            }
        }
        
        return false;
        
    }
}