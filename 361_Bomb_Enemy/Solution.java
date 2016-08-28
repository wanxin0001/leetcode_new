/*
361. Bomb Enemy  QuestionEditorial Solution  My Submissions
Total Accepted: 2800
Total Submissions: 7827
Difficulty: Medium
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

return 3. (Placing a bomb at (1,1) kills 3 enemies)
Credits:
Special thanks to @memoryless for adding this problem and creating all test cases.

Hide Company Tags Google
Hide Tags Dynamic Programming
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int[][] f = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            int left = 0;
            int right = 0;
            while (right < grid[0].length) {
                while (right < grid[0].length && grid[i][right] != 'W') {
                    
                    if (grid[i][right] == 'E') {
                        count++;
                    }
                    right++;
                }
                while(left < right) {
                    if (grid[i][left] == '0') {
                        f[i][left] += count;
                    }
                    left++;
                }
                
                right = right + 1;
                left = right;
                count = 0;
            }
        }
        
        
        for (int i = 0; i < grid[0].length; i++) {
            int count = 0;
            int slow = 0;
            int fast = 0;
            while (fast < grid.length) {
                while (fast < grid.length && grid[fast][i] != 'W') {
                    
                    if (grid[fast][i] == 'E') {
                        count++;
                    }
                    fast++;
                }
                while(slow < fast) {
                    if (grid[slow][i] == '0') {
                        f[slow][i] += count;
                    }
                    slow++;
                }
                
                fast++;
                slow = fast;
                count = 0;
            }
        }
        
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, f[i][j]);
            }
        }
        
        return max;
    }
}