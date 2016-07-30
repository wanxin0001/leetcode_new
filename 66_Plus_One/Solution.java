/*
66. Plus One  QuestionEditorial Solution  My Submissions
Total Accepted: 113247
Total Submissions: 324200
Difficulty: Easy
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Show Company Tags
Show Tags
Show Similar Problems

*/
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int count = 1; // It is not 0
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + count;
            list.add(0, val % 10);
            count = val / 10;
        }
        
        if (count == 1) {
            list.add(0, 1);
        }
        
        int[] array = new int[list.size()];
        int i = 0;
        for (int val : list) {
            array[i] = val;
            i++;
        }
        return array;
    }
}