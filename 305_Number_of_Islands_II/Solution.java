/*
Union-find: https://discuss.leetcode.com/topic/29613/easiest-java-solution-with-explanations/2
*/
public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        List<Integer> result = new ArrayList<Integer>();
        if (m <= 0 || n <= 0) {
            return result;
        }
        
        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);
        
        for (int[] p : positions) {
            int root = n * p[0] + p[1];
            roots[root] = root;
            count++;
            
            for (int[] dir : dirs) {
                int x = p[0] + dir[0];
                int y = p[1] + dir[1];
                int nb = x * n + y;
                
                if (x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) {
                    continue;
                }
                
                int rootNb = findIsland(roots, nb);
                if (root != rootNb) {
                    roots[root] = rootNb;
                    root = rootNb; //very necessary
                    count--;
                }
                
                
            }
            result.add(count);
        }
        
        return result;
    }
    
    public int findIsland(int[] roots, int id) {
        while (id != roots[id]) {
            id = roots[id];
        }
        
        return id;
    }
}