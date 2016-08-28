/*
28. Implement strStr()  QuestionEditorial Solution  My Submissions
Total Accepted: 123071
Total Submissions: 476173
Difficulty: Easy
Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() ==0) {
            return 0;
        }
        
        if (haystack == null || haystack.length() < needle.length()) {
            return - 1;
        }
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) { 
                    return i;
                }
            }
        }
        
        return -1;
    }
}