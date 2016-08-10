/*
67. Add Binary
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/
public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        
        if (b == null || b.length() == 0) {
            return a;
        }
        
        int[] list = new int[Math.max(a.length(), b.length()) + 1];
        
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            int val = count;
            if (a.length() - i - 1 >= 0) {
                val += a.charAt(a.length() - i - 1) - '0';
            }
            if (b.length() - i - 1 >= 0) {
                val += b.charAt(b.length() - i - 1) - '0'; 
            }
            
            list[list.length - 1 - i ] = val % 2;
            count = val / 2;
        }
        
        String result = "";
        for (int i = 0; i < list.length; i++) {
            if (i == 0 && list[i] != 1) {
                continue;
            }
            
            result += list[i];
        }
        
        return result;
    }
}