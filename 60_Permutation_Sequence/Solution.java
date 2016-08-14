/*
60. Permutation Sequence  QuestionEditorial Solution  My Submissions
Total Accepted: 61465
Total Submissions: 236950
Difficulty: Medium
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
/*
http://www.jiuzhang.com/solutions/permutation-sequence/
*/
public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];
        
        k = k - 1;
        int factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }
        
        for (int i = 0; i < n; i++) {
            int index = k / factor;
            k = k % factor;
            
            for (int j = 0; j < n; j++) {
                if (used[j] == false) {
                    if (index == 0) {
                        used[j] = true;
                        sb.append((char)('0' + j + 1)); //rather than sb.append('0' + j + 1)
                        break;
                    } else {
                        index--;
                    }
                }
            }
            if (i < n - 1) {
                factor = factor / (n - 1 - i);
            }
        }
        
        return sb.toString();
    }
}