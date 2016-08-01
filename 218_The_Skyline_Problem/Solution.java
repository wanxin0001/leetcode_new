/*
218. The Skyline Problem  QuestionEditorial Solution  My Submissions
Total Accepted: 21503
Total Submissions: 91128
Difficulty: Hard
A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).

 Buildings Skyline Contour
The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].

Notes:

The number of buildings in any input list is guaranteed to be in the range [0, 10000].
The input list is already sorted in ascending order by the left x position Li.
The output list must be sorted by the x position.
There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
Credits:
Special thanks to @stellari for adding this problem, creating these two awesome images and all test cases.

Show Company Tags
Show Tags

*/
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        if (buildings == null) {
            return result;
        }
        
        List<Point> criticalPoints = getCriticalPoints(buildings);
        for(int[] building : buildings) {
            for (Point point : criticalPoints) {
                if (point.x >= building[0] && point.x < building[1]) {
                    point.y = Math.max(point.y, building[2]);
                }
            }
        }
        
        
        for (int i = 0; i < criticalPoints.size(); i++) {
            Point current = criticalPoints.get(i);
            
            result.add(criticalPoints.get(i).getArray());
            while (i < criticalPoints.size() - 1 && current.y == criticalPoints.get(i + 1).y) {
                i++;
            }
        }
        
        return result;
        
    }
    
    private List<Point> getCriticalPoints(int[][] buildings) {
        Set<Point> set = new HashSet<Point>();
        for (int[] building : buildings) {
            set.add(new Point(building[0], 0));
            set.add(new Point(building[1], 0));
        }
        
        List<Point> list = new ArrayList<Point>();
        for (Point point : set) {
            list.add(point);
        }
        
        Collections.sort(list, comparator);
        
        
        return list;
    }
    
    private class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int[] getArray() {
            int[] array = {this.x, this.y};
            return array;
        }
        
        public boolean equals(Point point) {
            if (x == point.x && y == point.y) {
                return true;
            } else {
                return false;
            }
        }
        
        
    }
    
    private Comparator<Point> comparator = new Comparator<Point>(){
        @Override
        public int compare(Point point1, Point point2) {
            if (point1.x == point2.x) {
                return 0;
            } else if (point1.x > point2.x) {
                return 1;
            } else {
                return -1;
            }
        }
    };
}