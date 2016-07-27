/*
210. Course Schedule II  QuestionEditorial Solution  My Submissions
Total Accepted: 31571
Total Submissions: 144382
Difficulty: Medium
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

click to show more hints.
*/

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[0];
        if (numCourses < 0 || prerequisites == null) {
            return result;
        }
        
        if (numCourses <= 0) {
            return result;
        }
        
        int[] flag = new int[numCourses];
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
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0 ;i < numCourses; i++) {
            if (!canFinishDfs(map, flag, i, stack)) {
                return result;
            }
        }
        
        result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[numCourses - 1 - i] = stack.pop();
        }
        
        return result;
    }
    
    private boolean canFinishDfs(HashMap<Integer, List<Integer>> map, int[] flag, int course, Stack<Integer> stack) {
        if (flag[course] == -1) {
            return false;
        } else if (flag[course] == 1) {
            //stack.push(course) should not be there. Very important
            return true;
        }
        
        
        flag[course] = -1;
        if (map.containsKey(course)) {
            for (int pre : map.get(course)) {
                if (!canFinishDfs(map, flag, pre, stack)) {
                    return false;
                } 
            }
        }
        
        stack.push(course); //Very important.
        flag[course] = 1;
        
        return true;
    }
}