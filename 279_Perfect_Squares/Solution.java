/*
279. Perfect Squares  QuestionEditorial Solution  My Submissions
Total Accepted: 44284
Total Submissions: 130509
Difficulty: Medium
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
/*
Reference: https://discuss.leetcode.com/topic/23829/simple-java-solution
*/
public class Solution {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                f[i] = Math.min(f[i], f[i - j * j] + 1);
            }
        }
        
        return f[n];
    }
}