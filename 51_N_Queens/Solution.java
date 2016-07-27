/*
51. N-Queens  QuestionEditorial Solution  My Submissions
Total Accepted: 57709
Total Submissions: 216685
Difficulty: Hard
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (n <= 0) {
            return result;
        }
        
        int[] loc = new int[n];
        dfs(result, loc, 0);
        
        return result;
    }
    
    private void dfs(List<List<String>> result, int[] loc, int pos) {
        if (pos == loc.length) {
            List<String> tmp = printResult(loc);
            result.add(new ArrayList<String>(tmp));
            return;
        }
        
        for (int i = 0; i < loc.length; i++) {
            if (isValid(loc, i, pos)) {
                loc[pos] = i;
                dfs(result, loc, pos + 1);
            }
        }
    }
    
    private boolean isValid(int[] loc, int current, int pos) {
        for (int i = 0; i < pos; i++) {
            if (loc[i] == current || Math.abs(loc[i] - current) - Math.abs(i - pos) == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private List<String> printResult(int[] loc) {
        int length = loc.length;
        List<String> result = new ArrayList<String>();
        
        for(int i = 0; i < loc.length; i++) {
            String tmp = "";
            for (int j = 0; j < loc.length; j++) {
                if (loc[i] != j) {
                    tmp += ".";
                } else {
                    tmp += "Q";
                }
            }
            
            result.add(tmp);
        }
        
        return result;
    }
}