/*
207. Course Schedule  QuestionEditorial Solution  My Submissions
Total Accepted: 46022
Total Submissions: 163990
Difficulty: Medium
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
Hide Company Tags
*/

/*
Reference: http://www.programcreek.com/2014/05/leetcode-course-schedule-java/
*/

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            return false;
        }
        
        if (numCourses <= 1) {
            return true;
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], list);
            }
        }
        
        int[] flag = new int[numCourses]; // it is not prerequisites.length
        for (int i = 0; i < numCourses; i++) {
            if (!canDfsFinish(map, flag, i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean canDfsFinish(HashMap<Integer, List<Integer>> map, int[] flag, int course) {
        if (flag[course] == -1) {
            return false;
        } else if (flag[course] == 1) {
            return true;
        }
        
        flag[course] = -1;
        if (map.containsKey(course)) { // Very important
            for (int pre : map.get(course)) {
                if (!canDfsFinish(map, flag, pre)) {
                    return false;
                }
            }
        }
        flag[course] = 1;
        return true;
    }
}