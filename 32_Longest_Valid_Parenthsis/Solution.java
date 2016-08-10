/*
32. Longest Valid Parentheses  QuestionEditorial Solution  My Submissions
Total Accepted: 69388
Total Submissions: 304978
Difficulty: Hard
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
/*
Reference: https://discuss.leetcode.com/topic/53610/10-lines-8ms-c-dp-solution
*/
public class Solution {
    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int max = 0, openP = 0;
        int[] f = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openP++;
            } else if (openP > 0) {
                f[i] = 2 + f[i - 1];
                f[i] += i - f[i] > 0 ? f[i - f[i]] : 0;
                
                max = Math.max(max, f[i]);
                openP--;
            }
            
        }
        
        return max;
        
   }
}

// This solution will time exceed
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int accumulatedLen = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(i);
                continue;
            } else {
                if (stack.isEmpty()) {
                    accumulatedLen = 0;
                } else {
                    
                    int matchedPos = stack.pop();
                    int matchedLen = i - matchedPos + 1;
                    
                    if (stack.isEmpty()) {
                        accumulatedLen += matchedLen;
                        matchedLen = accumulatedLen;
                    } else {
                        matchedLen = i - stack.peek();
                    }
                    
                    maxLen = Math.max(maxLen, matchedLen);
                }
            }
        }
        
        return maxLen;
    }
}