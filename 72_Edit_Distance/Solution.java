/*
72. Edit Distance  QuestionEditorial Solution  My Submissions
Total Accepted: 63996
Total Submissions: 217327
Difficulty: Hard
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null) {
            return word2 == null ? 0 : word2.length();
        }
        
        if (word2 == null) {
            return word1.length();
        }
        
        int m = word1.length();
        int n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            f[i][0] = i;
        }
        
        for (int i = 0; i <= n; i++) {
            f[0][i] = i;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
                }
            }
        }
        
        return f[m][n];
    }
}