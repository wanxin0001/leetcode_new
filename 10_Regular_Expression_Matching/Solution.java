/*
10. Regular Expression Matching  QuestionEditorial Solution  My Submissions
Total Accepted: 90809
Total Submissions: 400952
Difficulty: Hard
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || s.length() == 0) {
            return checkEmpty(p);
        }
        
        if (p == null || p.length() == 0) {
            return false;
        }
        
        char s1 = s.charAt(0);
        char p1 = p.charAt(0);
        
        char p2 = '0';
        if (p.length() >= 2) {
           p2 = p.charAt(1);
        }
        
        if (p2 != '*') {
            if (compare(s1, p1)) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        } else {
            if (compare(s1, p1)) {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        }
    }
    
    private boolean compare(char s, char p) {
        return s == p || p == '.';
    }
    
    private boolean checkEmpty(String p) {
        if (p.length() % 2 != 0) {
            return false;
        }
        
        for (int i = 1; i < p.length(); i = i + 2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        
        return true;
    }
}