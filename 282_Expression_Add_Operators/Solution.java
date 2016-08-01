/*
282. Expression Add Operators  QuestionEditorial Solution  My Submissions
Total Accepted: 14127
Total Submissions: 53992
Difficulty: Hard
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
Credits:
Special thanks to @davidtan1890 for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/

/*
https://discuss.leetcode.com/topic/24523/java-standard-backtrace-ac-solutoin-short-and-clear

This problem has a lot of edge cases to be considered:

overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
a little trick is that we should save the value that is to be multiplied in the next recursion.
*/

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if (num == null || num.length() == 0) {
            return result;
        }
        
        helper(result, "", 0, num, target, 0, 0);
        
        return result;
    }
    
    private void helper(List<String> result, String tmp, int pos, String num, int target, long eval, long last) {
        if (pos == num.length()) {
            if (target == eval) {
                result.add(tmp);
            }
            return;
        }
        
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            } else {
                long current = Long.parseLong(num.substring(pos, i + 1));
                if (pos == 0) {
                    helper(result, Long.toString(current), i + 1, num, target, current, current);
                } else {
                    helper(result, tmp + "+" + Long.toString(current), i + 1, num, target, eval + current, current);
                    helper(result, tmp + "-" + Long.toString(current), i + 1, num, target, eval - current, 0 - current);
                    helper(result, tmp + "*" + Long.toString(current), i + 1, num, target, eval - last + last * current, last * current);
                }
            }
        }
    }
}