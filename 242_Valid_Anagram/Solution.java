/*
242. Valid Anagram  QuestionEditorial Solution  My Submissions
Total Accepted: 98336
Total Submissions: 227653
Difficulty: Easy
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            if (s == null && t == null) {
                return true;
            }
            
            return false;
        }
        
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        
        String newS = new String(sArray);
        String newT = new String(tArray);
        
        if (newS.equals(newT)) {
            return true;
        } else {
            return false;
        }
    }
    
}