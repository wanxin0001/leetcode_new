/*
293. Flip Game  QuestionEditorial Solution  My Submissions
Total Accepted: 12154
Total Submissions: 23661
Difficulty: Easy
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        
        if (s == null || s.length() <= 1) {
            return result;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            String cur = s.substring(i, i + 2);
            if (cur.equals("++")) {
                result.add(s.substring(0, i) + "--" + s.substring(i + 2));
            }
        }
        
        return result;
    }
}