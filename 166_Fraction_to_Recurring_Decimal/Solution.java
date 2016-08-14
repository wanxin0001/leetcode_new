/*
166. Fraction to Recurring Decimal  QuestionEditorial Solution  My Submissions
Total Accepted: 35912
Total Submissions: 225400
Difficulty: Medium
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
Show Hint 
Credits:
Special thanks to @Shangrila for adding this problem and creating all test cases.

Show Company Tags
Show Tags

*/
public class Solution {
    public String fractionToDecimal(int n1, int d1) {
        if (n1 == 0) {
            return "0";
        }
        
        if (d1 == 0) {
            return "";
        }
        
        String str = "";
        if ((n1 < 0) ^ (d1 < 0)) {
            str += "-";
        }
        
        long n = Math.abs((long) n1);
        long d = Math.abs((long) d1);
        
        str += Long.toString((n / d));
        
        if (n % d == 0) {
            return str;
        }
        
        str +=".";
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        
        long r = n % d;
        while (r != 0) {
            
            
            if (map.containsKey(r)) {
                str = str.substring(0, map.get(r)) + "(" + str.substring(map.get(r)) + ")";
                break;
            }
            
            map.put(r, str.length());
            
            r = r * 10;
            str += Integer.toString((int) (r / d));
            r = r % d;
            
        }
        
        return str;
    }
}