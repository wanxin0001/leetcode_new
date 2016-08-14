/*
149. Max Points on a Line  QuestionEditorial Solution  My Submissions
Total Accepted: 62441
Total Submissions: 420998
Difficulty: Hard
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        if (points.length == 1) {
            return 1;
        }
        
        int max = 0;
        
        for (int i = 0; i < points.length; i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            map.put((double) Integer.MIN_VALUE, 1);
            
            int dup = 0;
            Point cur = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point next = points[j];
                if (cur.x == next.x && cur.y == next.y) {
                    dup++;
                    continue;
                }
                double k = (cur.x == next.x) ? (double) Integer.MAX_VALUE : 0.0 + (double) (cur.y - next.y) / (cur.x - next.x);
                
                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 2);
                }
            }
            
            for (int count : map.values()) {
                
                max = Math.max(max, count + dup);
            }
            
            
        }
        
        return max;
    }
}