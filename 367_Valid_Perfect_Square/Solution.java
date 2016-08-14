/*
367. Valid Perfect Square  QuestionEditorial Solution  My Submissions
Total Accepted: 12203
Total Submissions: 33465
Difficulty: Medium
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        
        if (num <= 1 || num == 4) {
            return true;
        }
        
        long left = 1;
        long right = num / 2;
        while (left < right - 1) {
            long mid = (right - left) / 2 + left;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid;
            } else {
                right = mid;
            }
         }
         
         return false;
    }
}