/*
52. N-Queens II  QuestionEditorial Solution  My Submissions
Total Accepted: 47081
Total Submissions: 116737
Difficulty: Hard
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.



Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int[] loc = new int[n];
        int[] result = new int[1];
        dfs(result, loc, 0);
        
        return result[0];
    }
    
    private void dfs(int[] result, int[] loc, int pos) {
        if (pos == loc.length) {
            result[0]++;
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
    
    
}