/*
246. Strobogrammatic Number  QuestionEditorial Solution  My Submissions
Total Accepted: 12629
Total Submissions: 33771
Difficulty: Easy
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        
        int left = 0;
        int right = num.length() - 1;
        while (left < right) {
            char cur;
            if (num.charAt(left) == num.charAt(right)) {
                cur = num.charAt(left);
                if (cur == '1' || cur == '8' || cur == '0') {
                    left++;
                    right--;
                } else {
                    return false;
                }
            } else if (num.charAt(left) == '6' && num.charAt(right) == '9' || num.charAt(left) == '9' && num.charAt(right) == '6') {
                left++;
                right--;
            } else { // do not forget this condition.
                return false;
            }
        }
        
        if (left > right || left == right && num.charAt(left) == num.charAt(right) && (num.charAt(left) == '1' || num.charAt(left) == '8' || num.charAt(left) == '0') ) {
            return true;
        }
        return false;
    }
}