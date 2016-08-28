/*
58. Length of Last Word  QuestionEditorial Solution  My Submissions
Total Accepted: 106797
Total Submissions: 352863
Difficulty: Easy
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.

Hide Tags
*/
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }   
        
        int left = -1;
        int right = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && right == -1) {
                right = i;
                break;
            }
        }
        
        left = right;
        while(left >= 0) {
            if (s.charAt(left) != ' ') {
                left--;
            } else {
                break;
            }
        }
        
        if (right == -1) {
            return 0;
        }
        
        if (left == 0 && s.charAt(left) != ' ') {
            return right - left + 1;
        }
        
        return right - left;
    }
}