/*
241. Different Ways to Add Parentheses  QuestionEditorial Solution  My Submissions
Total Accepted: 26760
Total Submissions: 71162
Difficulty: Medium
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.

Show Tags
Show Similar Problems

*/

/*
Reference: https://discuss.leetcode.com/topic/19901/a-recursive-java-solution-284-ms
*/

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        if (input == null || input.length() == 0) {
            return result;
        }
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> list1 = diffWaysToCompute(part1);
                List<Integer> list2 = diffWaysToCompute(part2);
                int cur = 0;
                for (int val1 : list1) {
                    for (int val2 : list2) {
                        if (input.charAt(i) == '+') {
                            cur = val1 + val2;
                        } else if (input.charAt(i) == '-') {
                            cur = val1 - val2;
                        } else {
                            cur = val1 * val2;
                        }
                         result.add(cur);
                    }
                }
                
               
            }
        }
        
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        
        return result;
    }
}