/*
29. Divide Two Integers  QuestionEditorial Solution  My Submissions
Total Accepted: 74413
Total Submissions: 468296
Difficulty: Medium
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

Show Tags
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        if (dividend == 0) {
            return 0;
        }
        
        if (divisor == 1) {
            return dividend;
        }
        
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return 0 -  dividend;
        }
        
        boolean postive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? true : false;
        long dividend1 = Math.abs((long) dividend);
        long divisor1 = Math.abs((long) divisor);
        int result = 0;
        long cur = divisor1;
        int i = 1;
        while (dividend1 >= cur) {
            cur = cur << 1;
            i++;
        }
        cur = cur >> 1;
        i--;
        while (dividend1 >= divisor1) {
            if (dividend1 >= cur) {
                dividend1 -= cur;
                result += 1 << (i - 1);
                
            } 
            
            cur = cur >> 1;
            i--;
        }
        
        return postive ? result : 0 - result;
    }
}