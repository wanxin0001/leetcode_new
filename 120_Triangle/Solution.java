/*
120. Triangle  QuestionEditorial Solution  My Submissions
Total Accepted: 76976
Total Submissions: 247493
Difficulty: Medium
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Show Tags
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        
        int[] array = new int[triangle.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = triangle.get(triangle.size() - 1).get(i);
        }
        
        int size = triangle.size();
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
               array[j] = Math.min(array[j], array[j + 1]) + triangle.get(i).get(j);
            }
        }

        return array[0];
    }
}