/*
115. Distinct Subsequences  QuestionEditorial Solution  My Submissions
Total Accepted: 55423
Total Submissions: 187361
Difficulty: Hard
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

Show Tags
Have you met this question in a real interview? Yes  No
Discuss
*/
/*
http://www.jiuzhang.com/solutions/distinct-subsequences/
*/
public class Solution {
    
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        
        int[][] nums = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <=s.length(); i++) {
            nums[i][0] = 1;
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                nums[i][j] = nums[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    nums[i][j] += nums[i - 1][j - 1];
                }
            }
        }
        
        return nums[s.length()][t.length()];
        
    }

}