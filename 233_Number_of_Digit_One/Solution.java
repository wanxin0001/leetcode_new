/*
233. Number of Digit One  QuestionEditorial Solution  My Submissions
Total Accepted: 21554
Total Submissions: 83396
Difficulty: Hard
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

Hint:

Beware of overflow.
Show Tags
Show Similar Problems

*/
/*
https://discuss.leetcode.com/topic/18054/4-lines-o-log-n-c-java-python
*/
public class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m, b = n % m;
            ones += (int) ((a + 8) / 10 * m + ((a % 10 == 1) ? (b + 1) : 0));
        }
        
        return ones;
    }
}