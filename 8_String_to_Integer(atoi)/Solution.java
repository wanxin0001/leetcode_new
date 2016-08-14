/*
8. String to Integer (atoi)  QuestionEditorial Solution  My Submissions
Total Accepted: 115954
Total Submissions: 845554
Difficulty: Easy
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        int flag = 1;
        String tmp = "";
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == '+' || cur =='-' || (cur >= '0' && cur <= '9')) {
                tmp += cur;
            } else if (tmp.length() == 0 && cur == ' ') {
                continue;
            } else {
                break;
            }
        }
        
        if (tmp.length() == 0) {
            return 0;
        }
        
        String digits = "";
        for (int i = 0; i < tmp.length(); i++) {
            if (i == 0 && (tmp.charAt(i) == '+' || tmp.charAt(i) == '-')) {
                flag = tmp.charAt(i) == '+' ? 1: -1;
                continue;
            } else if (i!= 0){
                if (tmp.charAt(i) == '+' || tmp.charAt(i) == '-') {
                   break; 
                }
            }
            
            digits += tmp.charAt(i);
        }
        
        if (digits.length() == 0) {
            return 0;
        }
        long val = 0;
        long real = 0;
        for (int i = 0; i < digits.length(); i++) {
            val = 10 * val + (digits.charAt(i) - '0');
            real = val * flag;
            if (real >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (real <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        
        return (int) real;
    }
}