/*
20. Valid Parentheses  QuestionEditorial Solution  My Submissions
Total Accepted: 118119
Total Submissions: 392173
Difficulty: Easy
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Show Company Tags
Show Tags
Show Similar Problems

*/
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i + 1);
            if (str.equals("(") || str.equals("[") || str.equals("{")) {
                stack.push(str);
            } else {
                if (stack.size() != 0) { //Very necessary
                    String top = stack.pop();
                    if (str.equals(")") && top.equals("(")) {
                        continue;
                    } else if (str.equals("]") && top.equals("[")) {
                        continue;
                    } else if (str.equals("}") && top.equals("{")) {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}