/*
63. Unique Paths II  QuestionEditorial Solution  My Submissions
Total Accepted: 73375
Total Submissions: 244669
Difficulty: Medium
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            if (i == 0 && obstacleGrid[i][0] != 1) {
                f[i][0] = 1;
            } else {
                f[i][0] = obstacleGrid[i][0] == 1? 0 : f[i - 1][0];
            }
            
        }
        
        for (int j = 1; j < n; j++) {
            f[0][j] = obstacleGrid[0][j] == 1? 0 : f[0][j - 1];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = obstacleGrid[i][j] == 1? 0 : f[i][j  - 1] + f[i - 1][j];
            }
        }
        
        return f[m - 1][n -1];
    }
}