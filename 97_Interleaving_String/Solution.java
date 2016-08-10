/*
97. Interleaving String  QuestionEditorial Solution  My Submissions
Total Accepted: 54174
Total Submissions: 234319
Difficulty: Hard
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

Show Tags
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3 == null) {
            return false;
        }
        
        if (s1 == null) {
            s1 = "";
        }
        
        if (s2 == null) {
            s2 = "";
        }
        
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        } 
        
        int m = s1.length();
        int n = s2.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        
        f[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (f[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                f[i][0] = true;
            }
        }
        
        for (int j = 1; j <= n; j++) {
            if (f[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1)) {
                f[0][j] = true;
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (f[i - 1][j] && s3.charAt(i + j - 1) == s1.charAt(i - 1) || f[i][j - 1] && s3.charAt(i + j - 1) == s2.charAt(j - 1)) {  //Notice: s3's index is i + j - 1, rather than i + j -2;
                    f[i][j] = true;
                }
            }
        }
        
        return f[m][n];
    }
}