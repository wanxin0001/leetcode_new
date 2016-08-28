/*
294. Flip Game II  QuestionEditorial Solution  My Submissions
Total Accepted: 12412
Total Submissions: 29072
Difficulty: Medium
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/

/*
Reference: 
https://leetcode.com/problems/flip-game-ii/
*/

public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        return helper(s);
    }
    
    private boolean helper(String s) {
        boolean flag = false;
        for (int i = 0; i < s.length() - 1; i++) {
            String cur = s.substring(i, i + 2);
            if (cur.equals("++")) {
               flag = !helper(s.substring(0, i) + "--" + s.substring(i + 2));
            }
            
            if (flag) { //necessary
                return true;
            }
         }
        
        return false;
    }
}