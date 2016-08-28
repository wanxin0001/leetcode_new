/*
290. Word Pattern  QuestionEditorial Solution  My Submissions
Total Accepted: 47524
Total Submissions: 155038
Difficulty: Easy
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

Credits:
Special thanks to @minglotus6 for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0) {
            return false;
        }
        
        String[] items = str.split(" ");
        
        if (items.length != pattern.length()) {
            return false;
        }
        
        HashMap<Character, String> c2s = new HashMap<Character, String>();
        HashMap<String, Character> s2c = new HashMap<String, Character>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = items[i];
            
            if (!c2s.containsKey(c) && !s2c.containsKey(s)) {
                c2s.put(c, s);
                s2c.put(s, c);
            } else {
                if (c2s.containsKey(c) && s2c.containsKey(s)) {
                    if (c2s.get(c).equals(s) && s2c.get(s) == c) { // it is equals but not ==
                        continue;
                    }
                    
                   
                }
                return false;
            }
        }
        
        return true;
    }
}