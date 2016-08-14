/*
313. Super Ugly Number  QuestionEditorial Solution  My Submissions
Total Accepted: 20404
Total Submissions: 56861
Difficulty: Medium
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.

Credits:
Special thanks to @dietpepsi for adding this problem and creating all test cases.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss
*/
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        
        Arrays.sort(primes);
        
        int[] f = new int[n];

        
        int[] idxs = new int[primes.length];
        for (int i = 0; i < n; i++) {
            f[i] = Integer.MAX_VALUE;
            if (i == 0) {
                f[i] = 1;
                continue;
            }
            for (int j = 0; j < primes.length; j++) {
                int idx = idxs[j];
                int val = primes[j];
        
                while (f[idx] * val <= f[i - 1]) { //rather than <
                    idx++;
                }
                f[i] = Math.min(f[idx] * val, f[i]);
                idxs[j] = idx;
            }
        }
        
        return f[n - 1];
    }
}