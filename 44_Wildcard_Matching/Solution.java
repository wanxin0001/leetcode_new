/*
44. Wildcard Matching  QuestionEditorial Solution  My Submissions
Total Accepted: 64279
Total Submissions: 356010
Difficulty: Hard
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/
/*
Reference: https://discuss.leetcode.com/topic/3040/linear-runtime-and-constant-space-solution
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        int sIdx = 0, pIdx = 0, starIdx = -1, match = 0;
        while (sIdx < s.length()) {
            if (pIdx < p.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '?')) {
                sIdx++;
                pIdx++;
            } else if (pIdx < p.length() && p.charAt(pIdx) == '*') {
                starIdx = pIdx;
                match = sIdx;
                pIdx++;
            }  else if (starIdx != -1) {
                pIdx = starIdx + 1;
                match++;
                sIdx = match;
            } else {
                return false;
            }
        }
        
        while (pIdx < p.length() && p.charAt(pIdx) == '*') {
            pIdx++;
        }
        
        return pIdx == p.length();
    }
}