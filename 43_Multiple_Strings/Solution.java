/*
43. Multiply Strings  QuestionEditorial Solution  My Submissions
Total Accepted: 69785
Total Submissions: 284805
Difficulty: Medium
Given two numbers represented as strings, return multiplication of the numbers as a string.

Note:
The numbers can be arbitrarily large and are non-negative.
Converting the input string to integer is NOT allowed.
You should NOT use internal library such as BigInteger.
Show Company Tags
Show Tags
Show Similar Problems

*/
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return "";
        }
        
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        int[] array = new int[array1.length + array2.length];
        
        
        for (int i = array1.length - 1; i >= 0; i--) {
            for (int j = array2.length - 1; j >= 0; j--) {
                int cur =  (array1[i] - '0') * (array2[j] - '0');
                array[i + j + 1] +=  cur;
            }
        }
        
        int count = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            int val = count + array[i];
            array[i] = val % 10;
            count = val / 10;
        }
        
        String str = "";
        boolean noZero = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 && !noZero) {
                continue;
            } else {
                noZero = true;
            }
            
            str += Integer.toString(array[i]);
        }
        
        if (str.equals("")) {
            return "0";
        }
        
        return str;
    }
}