/*
323. Number of Connected Components in an Undirected Graph  QuestionEditorial Solution  My Submissions
Total Accepted: 10923
Total Submissions: 24843
Difficulty: Medium
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Show Company Tags
Hide Tags Depth-first Search Breadth-first Search Union Find Graph
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
/*
Reference: https://discuss.leetcode.com/topic/32752/easiest-2ms-java-solution/2
*/

public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 0) {
            return 0;
        }
        
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        
        int count = n;
        for (int[] e : edges) {
            int root1 = findRoot(e[0], roots);
            int root2 = findRoot(e[1], roots);
            
            if (root1 != root2) {
                roots[root1] = root2;
                count--;
            }
        }
        
        return count;
    }
    
    private int findRoot(int id, int[] roots) {
        while (roots[id] != id) {
            id = roots[id];
            roots[id]  = roots[roots[id]];
        }
        
        return id;
    }
    
    
}