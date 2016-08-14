/*
12. Integer to Roman  QuestionEditorial Solution  My Submissions
Total Accepted: 72587
Total Submissions: 178683
Difficulty: Medium
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
/*
Reference: http://www.jiuzhang.com/solutions/integer-to-roman/
*/
public class Solution {
    public String intToRoman(int num) {
        if (num <= 0) {
            return "";
        }
        
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    
	    StringBuilder builder = new StringBuilder();
	    
	    int digit = 0;
	    while (num > 0) {
	        int times = num / nums[digit];
	        num -= times * nums[digit];
	        
	        for (int i = 0; i < times; i++) {
	            builder.append(symbols[digit]);
	        }
	        digit++;
	    }
	    
	    return builder.toString();
	    
    }
}