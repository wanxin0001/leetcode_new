/*
342. Power of Four  QuestionEditorial Solution  My Submissions
Total Accepted: 33904
Total Submissions: 94008
Difficulty: Easy
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

Credits:
Special thanks to @yukuairoy for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        
        if (num == 1) {
            return true;
        }
        
        if (num % 4 != 0) {
            return false;
        }
        
        return isPowerOfFour(num / 4);
    }
}