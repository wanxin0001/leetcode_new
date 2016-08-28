/*
134. Gas Station  QuestionEditorial Solution  My Submissions
Total Accepted: 67686
Total Submissions: 242073
Difficulty: Medium
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

Show Tags
Have you met this question in a real interview? Yes  
*/
/*
https://discuss.leetcode.com/topic/1344/share-some-of-my-ideas
*/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, total = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
            total += gas[i] - cost[i];
        }
        
        if (total < 0) {
            return - 1;
        } else {
            return start;
        }
    }
}