/*
201. Bitwise AND of Numbers Range  QuestionEditorial Solution  My Submissions
Total Accepted: 41139
Total Submissions: 128264
Difficulty: Medium
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.

Credits:
Special thanks to @amrsaqr for adding this problem and creating all test cases.

Hide Tags Bit Manipulation
Have you met this question in a real interview? Yes  No
Discuss Pick One
*/

/*
The idea is very simple:

last bit of (odd number & even number) is 0.
when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
Move m and n rigth a position.
Keep doing step 1,2,3 until m equal to n, use a factor to record the iteration time.
https://discuss.leetcode.com/topic/12133/bit-operation-solution-java/2
*/
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        
        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        
        return m * moveFactor;
    }
}