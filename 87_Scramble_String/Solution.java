/*
87. Scramble String  QuestionEditorial Solution  My Submissions
Total Accepted: 50483
Total Submissions: 184929
Difficulty: Hard
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/
/*
Reference: http://www.jiuzhang.com/solutions/scramble-string/
*/
public class Solution {

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        
        if (s1.length() == 0 || s1.equals(s2)) {
            return true;
        }
        
        if (!simpleCheck(s1, s2)) {
            return false;
        }
        
        for (int i = 1; i < s1.length(); i++) {
            String s11 = s1.substring(0, i);
            String s12 = s1.substring(i);
            String s22 = s2.substring(0, i);
            
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)) ||
                isScramble(s1.substring(0, i), s2.substring(s2.length() - i, s2.length())) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                    return true;
                }
        }
        
        return false;
    }
    
    private boolean simpleCheck(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) {
            
            if  (array1[i] != array2[i]) {
                return false;
            }
        }
        
        return true;
    }
}
