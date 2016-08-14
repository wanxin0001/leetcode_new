/*
65. Valid Number  QuestionEditorial Solution  My Submissions
Total Accepted: 50968
Total Submissions: 413198
Difficulty: Hard
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
*/
/*
Reference: http://www.jiuzhang.com/solutions/valid-number/
*/
public class Solution {
    public boolean isNumber(String s) {
        int len = s.length();
        int left = 0, right = s.length() - 1;
        while (left <= right && Character.isWhitespace(s.charAt(left))) {
            left++;
        }
        if (left > right) {
            return false;
        }
        
        while (left <= right && Character.isWhitespace(s.charAt(right))) {
            right--;
        }
        
        if (s.charAt(left) == '+' || s.charAt(left) == '-') {
            left++;
        }
        
        boolean num = false, dot = false, exp = false;
        
        while (left <= right) {
            char c = s.charAt(left);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (exp || dot) {
                    return false;
                } else {
                    dot = true;
                }
            } else if (c == 'e') {
                if (exp || num == false) {
                    return false;
                }
                exp = true;
                num = false; //very nesscary
            } else if (c == '+' || c == '-') {
                if (s.charAt(left - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            left++;
        }
        
        return num;
    }
}