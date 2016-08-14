/*
356. Line Reflection  QuestionEditorial Solution  My Submissions
Total Accepted: 2559
Total Submissions: 8980
Difficulty: Medium
Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?

Hint:

Find the smallest and largest x-value for all points.
If there is a line then it should be at y = (minX + maxX) / 2.
For each point, make sure that it has a reflected point in the opposite side.
Credits:
Special thanks to @memoryless for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public boolean isReflected(int[][] points) {
        if (points == null || points.length == 0) {
            return true;
        }
        
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for (int i = 0; i < points.length; i++) {
            left = Math.min(left, points[i][0]);
            right = Math.max(right, points[i][0]);
            
            int x = points[i][0];
            int y = points[i][1];
            if (map.containsKey(x)) {
                map.get(x).add(y);
            } else {
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(y);
                map.put(x, set);
            }
        }
        
        double mid = (double) (right - left) / 2 + left; //need two double
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            
            int reflected = (int) (2 * mid) - x;
            if (map.containsKey(reflected) && map.get(reflected).contains(y)) {
                continue;
            } else {
                return false;
            }
        }
        
        return true;
    }
}