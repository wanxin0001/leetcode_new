/*
261. Graph Valid Tree  QuestionEditorial Solution  My Submissions
Total Accepted: 14953
Total Submissions: 44138
Difficulty: Medium
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

For example:

Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

Hint:

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree? Show More Hint 
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Show Company Tags
Show Tags
Show Similar Problems

*/

/*
The logic is complex and need to revise.
*/

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n < 0 || edges == null) {
            return false;
        }
        
        if (n <= 1) {
            return true;
        }
        
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(edges[i][1]);
                map.put(edges[i][0], set);
            }
            
            if (map.containsKey(edges[i][1])) {
                map.get(edges[i][1]).add(edges[i][0]);
            } else {
                Set<Integer> set = new HashSet<Integer>();
                set.add(edges[i][0]);
                map.put(edges[i][1], set);
            }
        }
        
        boolean[] flag = new boolean[n];
        if (!canFinishDfs(map, flag, 0)) {
            return false;
        }
        
        for (int i = 0; i < n; i++) {
            if (flag[i] != true) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean canFinishDfs(HashMap<Integer, Set<Integer>> map, boolean[] flag, int i) {
        if (flag[i] == true) {
            return false;
        }
        
        flag[i] = true;
        if (map.containsKey(i)) {
            for (int neighbor : map.get(i)) {
                map.get(neighbor).remove(i);
                if (!canFinishDfs(map, flag, neighbor)) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
