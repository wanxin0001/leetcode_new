/*
302. Smallest Rectangle Enclosing Black Pixels  QuestionEditorial Solution  My Submissions
Total Accepted: 7017
Total Submissions: 17004
Difficulty: Hard
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.

Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int[] array = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
        
        boolean[][] f = new boolean[image.length][image[0].length];
        dfs(array, f, image, x, y);
        
        return (1 + Math.abs(array[0] - array[1])) * (Math.abs(array[2] - array[3]) + 1); //do not forget to add 1
    }
    
    private void dfs(int[] array, boolean[][] f, char[][] image, int x, int y) {
        if (f[x][y]) {
            return;
        }
        array[0] = Math.min(array[0], x);
        array[1] = Math.max(array[1], x);
        array[2] = Math.max(array[2], y);
        array[3] = Math.min(array[3], y);
        
        f[x][y] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int nextX = dir[0] + x;
            int nextY = dir[1] + y;
            if (nextX >= 0 && nextX < f.length && nextY >= 0 && nextY < f[0].length && image[nextX][nextY] == '1') {
                dfs(array, f, image, nextX, nextY);
            }
        }
        
    }
}