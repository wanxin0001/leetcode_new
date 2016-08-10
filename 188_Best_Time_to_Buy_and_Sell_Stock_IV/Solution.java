/*
188. Best Time to Buy and Sell Stock IV  QuestionEditorial Solution  My Submissions
Total Accepted: 30548
Total Submissions: 132374
Difficulty: Hard
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.

Hide Tags Dynamic Programming
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
/*

 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 
https://discuss.leetcode.com/topic/26169/clean-java-dp-solution-with-comment
*/
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int size = prices.length;
        
        if (size <= 1) {
            return 0;
        }
        
        if (size / 2 <= k) {
            int maxPro = 0;
            for (int i = 1; i < size; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    maxPro += prices[i] - prices[i - 1];
                }
            }
            
            return maxPro;
        }
        
        int[][] f = new int[k + 1][size];
        for (int i = 1; i <= k; i++) {
            int localMax = f[i - 1][0] - prices[0];
            for (int j = 1; j < size; j++) {
                f[i][j] = Math.max(f[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, f[i - 1][j] - prices[j]);
            }
        }
        
        return f[k][size - 1];
        
    }
}