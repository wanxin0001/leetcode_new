/*
79. Word Search  QuestionEditorial Solution  My Submissions
Total Accepted: 81212
Total Submissions: 343998
Difficulty: Medium
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        
        if (board == null || board.length == 0) {
            return false;
        }
        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, flag, i, j)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, boolean[][] flag, int i, int j) {
        if (word.length() == 0) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || flag[i][j] == true) { //flag[i][j] is necessary.
            return false;
        }
        
        if (board[i][j] == word.charAt(0)) {
            flag[i][j] = true;
            if (dfs(board, word.substring(1), flag, i + 1, j)) {
                return true;   
            } else if (dfs(board, word.substring(1), flag, i - 1, j)) {
                return true;
            } else if (dfs(board, word.substring(1), flag, i, j - 1)) {
                return true;
            } else if (dfs(board, word.substring(1), flag, i, j + 1)) {
                return true;
            }
            
            flag[i][j] = false;
        } 
        return false;
    }
}