/*
326. Power of Three  QuestionEditorial Solution  My Submissions
Total Accepted: 58257
Total Submissions: 152962
Difficulty: Easy
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.
*/
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        
        if (n == 1) {
            return true;
        }
        
        long i = 3;
        while(i <= n) {
            if (i == n) {
                return true;
            }
            i = i * 3;
        }
        
        return false;
    }
}