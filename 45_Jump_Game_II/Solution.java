/*
45. Jump Game II  QuestionEditorial Solution  My Submissions
Total Accepted: 69681
Total Submissions: 271825
Difficulty: Hard
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.

Show Tags
Have you met this question in a real interview? Yes  
*/
/*
Greedy Algorithm to solve this problem. DP will cause time exceeds.
Reference: http://www.jiuzhang.com/solutions/jump-game-ii/
*/
public class Solution {
    public int jump(int[] A) {
        
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int farthest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > farthest) {
                    farthest = A[i] + i;
                }
            }
            start = end + 1;
            end = farthest;
        }
        
        return jumps;
    }
}