/*
70. Climbing Stairs  QuestionEditorial Solution  My Submissions
Total Accepted: 121568
Total Submissions: 324390
Difficulty: Easy
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        
        return f[n];
    }
}