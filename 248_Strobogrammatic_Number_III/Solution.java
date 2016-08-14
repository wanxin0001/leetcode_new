/*
248. Strobogrammatic Number III  QuestionEditorial Solution  My Submissions
Total Accepted: 5183 Total Submissions: 18217 Difficulty: Hard
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

For example,
Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

Note:
Because the range might be a large number, the low and high numbers are represented as string.

Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

/*
Reference: https://discuss.leetcode.com/topic/31386/easiest-20ms-94-java-solution/2
*/
public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        
        int[] count = {0};
        
        for (int len = low.length(); len <= high.length(); len++) {
            dfs(low, high, new char[len], count, 0, len - 1, pairs);
        }
        
        return count[0];
    }
    
    private void dfs(String low, String high, char[] c, int[] count, int left, int right, char[][] pairs) {
        if (left > right) {
            String s = new String(c);
            if ((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0)) {
                return;
            }
            
            count[0]++;
            return;
        }
        
        for (char[] p : pairs) {
            c[left] = p[0];
            c[right] = p[1];
            if (c.length != 1 && c[0] == '0') {
                continue;
            }
            
            if (left < right || left == right && p[0] == p[1]) {
                dfs(low, high, c, count, left + 1, right - 1, pairs);
            }
        }
    }
}