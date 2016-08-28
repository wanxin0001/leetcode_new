/*
306. Additive Number  QuestionEditorial Solution  My Submissions
Total Accepted: 15191
Total Submissions: 56923
Difficulty: Medium
Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

For example:
"112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.

1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
"199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
1 + 99 = 100, 99 + 100 = 199
Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Follow up:
How would you handle overflow for very large input integers?

Credits:
Special thanks to @jeantimex for adding this problem and creating all test cases.

Show Company Tags
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() <= 2) {
            return false;
        }
        for (int i = 1; i <= num.length() - 2; i++) {
            if (num.charAt(0) == '0' && i > 1) {
                break;
            }
            long first = Long.parseLong(num.substring(0, i));
            
            long second = 0;
            for (int j = i + 1; j <= num.length() - 1; j++) {
                if (num.charAt(i) == '0' && j - i > 1) {
                    break;
                }
                second = Long.parseLong(num.substring(i, j));
                long sum = first + second;
                
                if (helper(first, second, num.substring(j))) {
                    return true;
                }
            }
            
        }
        
        return false;
    }
    
    private boolean helper(long first, long second, String last) {
        if (last.length() == 0) {
            System.out.println(first + " 1 " + second + " 1 " + last);
            return true;
        }
        
        String str = Long.toString(first + second);
        System.out.println(first + " " + second + " " + last + " " + str);
        if (last.length() >= str.length() && last.substring(0, str.length()).equals(str)) { //necessary last.length() >= str.length()
            System.out.println("true");
            return helper(second, first + second, last.substring(str.length()));
        }
        
        return false;
    }
}