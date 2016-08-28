/*
69. Sqrt(x)  QuestionEditorial Solution  My Submissions
Total Accepted: 107596
Total Submissions: 412276
Difficulty: Medium
Implement int sqrt(int x).

Compute and return the square root of x.

Hide Company Tags Bloomberg Apple Facebook
Hide Tags Binary Search Math
Hide Similar Problems (M) Pow(x, n) (M) Valid Perfect Square
Have you met this question in a real interview? Yes  No
Discuss Pick One

*/
public class Solution {
    public int mySqrt(int x) {
       if (x < 0) {
           return -1;
       }
       
       if (x <= 1) {
           return x;
       }
       
       long left = 1;
       long right = x;
       
       while (left < right - 1) {
           long mid = (right - left) / 2 + left;
           long val = mid * mid;
           
           if (val == x) {
               return (int) mid;
           } else if (val > x) {
               right = mid;
           } else {
               left = mid;
           }
       }
       
       if (right * right > x) {
           return (int) left;
       } else {
           return (int) right;
       }
    }
}