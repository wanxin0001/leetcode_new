/*
372. Super Pow  QuestionEditorial Solution  My Submissions
Total Accepted: 5294
Total Submissions: 17326
Difficulty: Medium
Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024
Credits:
Special thanks to @Stomach_ache for adding this problem and creating all test cases.
*/
/*
Reference: https://discuss.leetcode.com/topic/50489/c-clean-and-short-solution/8
*/
public class Solution {
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length, 1337);
    }
    
    private int superPow(int a, int[] b, int length, int k) {
        if (length == 1) {
            return powMod(a, b[0], k);
        }
        
        return powMod(superPow(a, b, length - 1, k), 10, k) * powMod(a, b[length - 1], k) % k;
    }
    
    private int powMod(int x, int y, int k) {
        int pow = 1;
        x = x % k;
        for (int i = 0; i < y; i++) {
            pow = (pow * x) % k;
        }
        
        return pow;
    }
}