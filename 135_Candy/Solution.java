/*
135. Candy  QuestionEditorial Solution  My Submissions
Total Accepted: 56734
Total Submissions: 244517
Difficulty: Hard
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Show Tags
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public int candy(int[] ratings) {
        int count = 0;
        if (ratings == null || ratings.length == 0) {
            return count;
        }
        
        int[] f = new int[ratings.length];
        f[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                f[i] = f[i - 1] + 1;
            } else {
                f[i] = 1;
            }
        }
        
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && f[i] <= f[i + 1]) {
                f[i] = f[i + 1] + 1;
            }
        }
        
        for (int val : f) {
            count += val;
        }
        
        return count;
    }
}