/*
22. Generate Parentheses  QuestionEditorial Solution  My Submissions
Total Accepted: 95622
Total Submissions: 250004
Difficulty: Medium
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
Show Company Tags
Show Tags
Show Similar Problems

*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        
        dfs(result, "", n, n);
        return result;
    }
    
    private void dfs(List<String> result, String tmp, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(tmp);
            return;
        }
        
        if (left > 0) {
            dfs(result, tmp + "(", left - 1, right);
        }
        
        if (right > left) {
            dfs(result, tmp + ")", left, right - 1);
        }
    }
}