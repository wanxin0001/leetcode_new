/*
320. Generalized Abbreviation  QuestionEditorial Solution  My Submissions
Total Accepted: 9941
Total Submissions: 23894
Difficulty: Medium
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Hide Company Tags Google
Hide Tags Backtracking Bit Manipulation
Hide Similar Problems (M) Subsets (E) Unique Word Abbreviation
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
/*
Reference: https://discuss.leetcode.com/topic/32765/java-14ms-beats-100/2
*/
public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        dfs(res, new StringBuilder(), word.toCharArray(), 0, 0);
        
        return res;
    }
    
    public void dfs(List<String> res, StringBuilder sb, char[] c, int i, int num) {
        int len = sb.length();
        if (i == c.length) {
            if (num != 0) {
                sb.append(num);
            }
            res.add(sb.toString());
        } else {
            dfs(res, sb, c, i + 1, num + 1);
            
            if (num != 0) {
                sb.append(num);
            }
            dfs(res, sb.append(c[i]), c, i + 1, 0);
        }
        sb.setLength(len);  //very necessary
    }
}