/*
264. Ugly Number II  QuestionEditorial Solution  My Submissions
Total Accepted: 37654
Total Submissions: 126184
Difficulty: Medium
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
*/
/*
Reference: http://www.jiuzhang.com/solutions/ugly-number-ii/
*/
public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);
        
        int p2 = 0, p3 = 0, p5 = 0;
        
        for (int i = 1; i < n; i++) {
            int last = uglys.get(i - 1);
            while(uglys.get(p2) * 2 <= last) {
                p2++;
            }
            while(uglys.get(p3) * 3 <= last) {
                p3++;
            }
            while(uglys.get(p5) * 5 <= last) {
                p5++;
            }
            
            uglys.add(Math.min(uglys.get(p2) * 2, Math.min(uglys.get(p3) * 3, uglys.get(p5) * 5)));
        }
        
        return uglys.get(n - 1);
    }
}