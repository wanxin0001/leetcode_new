/*
357. Count Numbers with Unique Digits  QuestionEditorial Solution  My Submissions
Total Accepted: 10930
Total Submissions: 25281
Difficulty: Medium
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

Hint:

A direct way is to use the backtracking approach.
Backtracking should contains three states which are (the current number, number of steps to get that number and a bitmask which represent which number is marked as visited so far in the current number). Start with state (0,0,0) and count all valid number till we reach number of steps equals to 10n.
This problem can also be solved using a dynamic programming approach and some knowledge of combinatorics.
Let f(k) = count of numbers with unique digits with length equals k.
f(1) = 10, ..., f(k) = 9 * 9 * 8 * ... (9 - k + 2) [The first factor is 9 because a number cannot start with 0].
Credits:
Special thanks to @memoryless for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n < 0 || n > 10) {
            return 0;
        }
        
        
        int[] f = new int[n + 1];
        f[0] = 1;
        
        
        for (int i = 1; i <= n; i++) {
            int val = 1;
            int digits = i;
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    val = 9;
                } else {
                    val *= 9 - j + 1;
                }
            }
            
            f[i] = f[i - 1] + val;
        }
        
        return f[n];
    }
}