/*
172. Factorial Trailing Zeroes  QuestionEditorial Solution  My Submissions
Total Accepted: 67274
Total Submissions: 199347
Difficulty: Easy
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int trailingZeroes(int n) {
        if (n < 0) {
            return 0;
        }
        int count = 0;
        while (n != 0) {
            count += n / 5;
            n = n / 5;
        }
        
        return count;
    }
}