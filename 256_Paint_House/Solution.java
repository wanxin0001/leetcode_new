/*
256. Paint House  QuestionEditorial Solution  My Submissions
Total Accepted: 10205
Total Submissions: 23255
Difficulty: Medium
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        
        int[][] f = new int[costs.length][costs[0].length];
        for (int i = 0; i < costs[0].length; i++) {
            f[0][i] = costs[0][i];
        }
        
        for (int i = 1; i < costs.length; i++) {
            f[i][0] = Math.min(f[i - 1][1], f[i - 1][2]) + costs[i][0];
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][2]) + costs[i][1];
            f[i][2] = Math.min(f[i - 1][0], f[i - 1][1]) + costs[i][2];
        }
        
        return Math.min(Math.min(f[f.length - 1][0], f[f.length - 1][1]), f[f.length - 1][2]);
    }
}