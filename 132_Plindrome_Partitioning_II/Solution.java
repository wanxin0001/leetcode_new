/*
132. Palindrome Partitioning II  QuestionEditorial Solution  My Submissions
Total Accepted: 54951
Total Submissions: 244387
Difficulty: Hard
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

Show Tags
Show Similar Problems

*/

/*
Reference: https://discuss.leetcode.com/topic/2840/my-solution-does-not-need-a-table-for-palindrome-is-it-right-it-uses-only-o-n-space/2
*/
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        
        int size = s.length();
        int[] f = new int[s.length() + 1];
        
        for (int i = 0; i < f.length; i++) {
            f[i] = i - 1; //rather than i
        }
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; i - j >= 0 && i + j < size && s.charAt(i - j) == s.charAt(i + j); j++) {
                f[i + j + 1] = Math.min(f[i + j  + 1], f[i - j] + 1);
            }
            
            for (int j = 1; i - j + 1 >= 0 && i + j < size && s.charAt(i - j + 1) == s.charAt(i + j); j++ ) {
                f[i + j + 1] = Math.min(f[i + j + 1], f[i - j + 1] + 1);
            }
        }
        
        return f[s.length()];
    }
    
    
}




/*
This solution will execeed time.
*/
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        
        int size = s.length();
        boolean[][] f = getF(s);
        
        int[] array = new int[size + 1];
        array[0] = -1;
        for (int i = 1; i < size + 1; i++) {
            array[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (f[j][i]) {
                    array[i] = Math.min(array[i], array[j] + 1);
                } else {
                    array[i] = Math.min(array[i], array[i - 1] + 1);
                }
            }
        }
        
        return array[s.length()];
    }
    
    private boolean[][] getF(String s) {
        int size = s.length();
        boolean[][] f = new boolean[size + 1 ][size + 1];
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                
                f[j][i] = isPalindrome(s.substring(j, i));
                
            }
        }
        
        
        
        return f;
    }
    
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}