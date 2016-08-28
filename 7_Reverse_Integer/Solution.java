/*
7. Reverse Integer  QuestionEditorial Solution  My Submissions
Total Accepted: 156648
Total Submissions: 658313
Difficulty: Easy
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior.
*/

public class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        long val = Math.abs((long) x);
        long tmp = 0;
        
        while (val != 0) {
            tmp = 10 * tmp + val % 10;
            val = val / 10;
        }
        
        long result = tmp * sign;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        
        return (int) result;
    }
}