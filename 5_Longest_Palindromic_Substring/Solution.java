/*
5. Longest Palindromic Substring  QuestionEditorial Solution  My Submissions
Total Accepted: 126429
Total Submissions: 531880
Difficulty: Medium
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

Hide Company Tags Amazon Microsoft Bloomberg
Hide Tags String
Hide Similar Problems (H) Shortest Palindrome (E) Palindrome Permutation (H) Palindrome Pairs
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String s1 = helper(s, i, i);
            String s2 = helper(s, i, i + 1);
            result = s1.length() > result.length() ? s1 : result;
            result = s2.length() > result.length() ? s2 : result;
        }
        
        return result;
    }
    
    private String helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right); //rather than left, right + 1
    }
}