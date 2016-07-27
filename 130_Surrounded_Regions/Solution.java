/*
130. Surrounded Regions  QuestionEditorial Solution  My Submissions
Total Accepted: 57254
Total Submissions: 347094
Difficulty: Medium
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        int width = board[0].length;
        int height = board.length;
        
        for (int i = 0; i < width; i++) {
            bfs(board, 0, i);
            bfs(board, height - 1, i);
        }
        
        for (int j = 1; j < height - 1; j++) {
            bfs(board, j, 0);
            bfs(board, j, width - 1);
        }
        
        helper(board);
        
        return;
    }
    
    private void bfs(char[][] board, int x, int y) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int width = board[0].length;
        int height = board.length;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[][] flag = new boolean[board.length][board[0].length];  //It is very important. If we don't have this flag, it will timeout.
        if (board[x][y] == 'O') {
            queue.offer(x * width + y);
            flag[x][y] = true;
        }
        
        while (queue.size() != 0) {
            int val = queue.poll();
            int xVal = val / width;
            int yVal = val % width;
            board[xVal][yVal] = 'D';
            for (int[] dir : dirs) {
                int nearbyX = xVal + dir[0];
                int nearbyY = yVal + dir[1];
                if (nearbyX >= 0 && nearbyX < board.length && nearbyY >= 0 && nearbyY < board[0].length && board[nearbyX][nearbyY] == 'O') {
                    if (!flag[nearbyX][nearbyY]) {
                        queue.offer(nearbyX * width + nearbyY);
                        flag[nearbyX][nearbyY] = true;
                    }
                }
            }
        }
    }
    
    private void helper(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}