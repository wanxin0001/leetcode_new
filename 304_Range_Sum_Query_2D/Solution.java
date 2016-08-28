/*
304. Range Sum Query 2D - Immutable  QuestionEditorial Solution  My Submissions
Total Accepted: 18387
Total Submissions: 81491
Difficulty: Medium
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
/*
https://leetcode.com/articles/range-sum-query-2d-immutable/
*/
public class NumMatrix {
    private int[][] f;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        
        f = new int[matrix.length + 1][matrix[0].length + 1];
        for (int r = 0; r < f.length - 1; r++) {
            for (int c = 0; c < f[0].length - 1; c++) {
                f[r + 1][c + 1] = f[r + 1][c] + f[r][c + 1] - f[r][c] + matrix[r][c]; 
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return f[row2 + 1][col2 + 1] +  f[row1][col1] - f[row2 + 1][col1] - f[row1][col2 + 1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);