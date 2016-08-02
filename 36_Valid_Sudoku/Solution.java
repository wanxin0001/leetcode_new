/*
36. Valid Sudoku  QuestionEditorial Solution  My Submissions
Total Accepted: 83518
Total Submissions: 262014
Difficulty: Easy
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

Show Company Tags
Show Tags
Show Similar Problems

*/
public class Solution {
    public boolean isValidSudoku(char[][] board) {
       boolean[] visited = new boolean[9];
       //row
       for (int i = 0; i < 9; i++) {
           Arrays.fill(visited, false);
           for (int j = 0; j < 9; j++) {
               if (!process(visited, board[i][j])) {
                   return false;
               }
           }
       }
       
       // column
       for (int j = 0; j < 9; j++) {
           Arrays.fill(visited, false);
           for (int i = 0; i < 9; i++) {
               if (!process(visited, board[i][j])) {
                   return false;
               }
           }
       }
       
       for (int i = 0; i < 9; i = i + 3) {
           for (int j = 0; j < 9; j = j + 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!process(visited, board[i + k / 3][j + k % 3])) {
                        return false;
                    }
                }
           }
           
       }
       
       return true;
    }
    
    private boolean process(boolean[] visited, char digit) {
        if (digit == '.') {
            return true;
        }
        int num = digit - '0';
        if (num < 1 || num > 9 || visited[num - 1]) {
            return false;
        }
        
        visited[num - 1] = true;
        return true;
    }
}