/*
168. Excel Sheet Column Title  QuestionEditorial Solution  My Submissions
Total Accepted: 69968
Total Submissions: 305952
Difficulty: Easy
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0 ) {
            return "";
        } 
        
        String str = "";
        while (n != 0) {
            char cur = (char) ((n - 1) % 26 + 'A');
            str = cur + str;
            n = (n - 1) / 26;
        }
        
        return str;
    }
}