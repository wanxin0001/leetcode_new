/*
151. Reverse Words in a String  QuestionEditorial Solution  My Submissions
Total Accepted: 114087
Total Submissions: 723039
Difficulty: Medium
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String[] items = s.split(" ");
        String str = "";
        for (int i = items.length - 1; i >= 0; i--) {
            if (items[i].length() != 0) {
                str += items[i] + " ";
            }
        }
        
        return str.length() == 0 ? str : str.substring(0, str.length() - 1);
    }
}