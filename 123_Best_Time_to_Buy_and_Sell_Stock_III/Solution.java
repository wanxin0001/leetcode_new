/*
123. Best Time to Buy and Sell Stock III  QuestionEditorial Solution  My Submissions
Total Accepted: 62705
Total Submissions: 231395
Difficulty: Hard
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

//DP issue
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }
        
        
        int result = 0;
        for (int i = 0;i < prices.length; i++) {
            result = Math.max(result, left[i] + right[i]);
        }
        
        return result;
    }
}