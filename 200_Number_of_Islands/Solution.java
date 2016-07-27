/*
200. Number of Islands  QuestionEditorial Solution  My Submissions
Total Accepted: 53107
Total Submissions: 183176
Difficulty: Medium
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.
*/

public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int x = grid.length;
        int y = grid[0].length;
        boolean[][] flag= new boolean[x][y];
        
        int count = 0;
        
        for (int i = 0; i < x; i++) {
            for (int j = 0; j< y; j++) {
                if (grid[i][j] == '1' && flag[i][j] == false) {
                    count++;
                    Queue<Node> queue = new LinkedList<Node>();
                    Node node = new Node(i, j);
                    queue.offer(node);
                    
                    while(queue.size() != 0) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            Node current = queue.poll();
                            
                            int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
                            for (int[] dir : dirs) {
                                int xNeighbor = current.x + dir[0];
                                int yNeighbor = current.y + dir[1];
                                if (xNeighbor >= 0 && xNeighbor < x && yNeighbor >=0 && yNeighbor < y) {
                                    if (grid[xNeighbor][yNeighbor] == '1' && !flag[xNeighbor][yNeighbor]) {
                                        Node neighbor = new Node(xNeighbor, yNeighbor);
                                        queue.offer(neighbor);
                                        flag[xNeighbor][yNeighbor] = true; //this place is very important.
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return count;
    }
    
    private class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
       
    }
}