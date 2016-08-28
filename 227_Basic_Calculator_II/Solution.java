/*
227. Basic Calculator II  QuestionEditorial Solution  My Submissions
Total Accepted: 28914
Total Submissions: 108537
Difficulty: Medium
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/
/*
Reference: https://discuss.leetcode.com/topic/16935/share-my-java-solution
*/
public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        
        int num = 0;
        char sign = '+';
        
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = 10 * num + s.charAt(i) - '0';
            }
            
            if (!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i) || i == len - 1) {
                if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '+') {
                    stack.push(num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                
                sign = s.charAt(i);
                num = 0;
                
            } 
        }
        
        int result = 0;
        for (int i : stack) {
            result += i;
        }
        
        return result;
    }
}