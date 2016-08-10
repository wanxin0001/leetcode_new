/*
139. Word Break  QuestionEditorial Solution  My Submissions
Total Accepted: 96460
Total Submissions: 367245
Difficulty: Medium
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        
        int max = Integer.MIN_VALUE;
        for (String word : wordDict) {
            max = Math.max(word.length(), max);
        }
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        //f[i] means if the word can break for the str [0, i)
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= i - max && j >= 0; j--) { //j >= 0 is necessary
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}