/*
311. Sparse Matrix Multiplication  QuestionEditorial Solution  My Submissions
Total Accepted: 9233
Total Submissions: 19002
Difficulty: Medium
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
Show Company Tags
Show Tags

*/
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length]; //rather than B.length
        
        boolean[] fA = flagA(A);
        boolean[] fB = flagB(B);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                if (!fA[i] && !fB[j]) {
                    result[i][j] = helper(A, B, i, j);
                }
            }
        }
        
        return result;
    }
    
    private boolean[] flagA(int[][] matrix) {
        boolean[] f = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            boolean flag = true;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    flag = false;
                }
            }
            
            f[i] = flag;
        }
        
        return f;
    }
    
    private boolean[] flagB(int[][] matrix) {
        boolean[] f = new boolean[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            boolean flag = true;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] != 0) {
                    flag = false;
                }
            }
            
            f[j] = flag;
        }
        
        return f;
    }
    
    
    private int helper(int[][] A, int[][] B, int i, int j) {
        int sum = 0;
        for (int k = 0; k < A[0].length; k++) {
            sum += A[i][k] * B[k][j];
        }
        
        return sum;
    }
}