/*
308. Range Sum Query 2D - Mutable  QuestionEditorial Solution  My Submissions
Total Accepted: 5186
Total Submissions: 24810
Difficulty: Hard
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
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

public class NumMatrix {
    private int[][] f;
    private int[][] matrix; //necessary
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.matrix = matrix; //necessary
        f = new int[matrix.length][matrix[0].length + 1];
        
        for (int r = 0; r < f.length; r++) {
            for (int c = 0; c < f[0].length - 1; c++) {
                f[r][c + 1] = f[r][c] + matrix[r][c];
            }
        }
    }

    public void update(int row, int col, int val) {
        for (int c = col; c < f[0].length - 1; c++) {
            f[row][c + 1] += val - matrix[row][col];
            
        }
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += f[row][col2 + 1] - f[row][col1];
        }
        
        return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);