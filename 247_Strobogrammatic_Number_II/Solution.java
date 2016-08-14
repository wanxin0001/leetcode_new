/*
247. Strobogrammatic Number II  QuestionEditorial Solution  My Submissions
Total Accepted: 10984
Total Submissions: 30728
Difficulty: Medium
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].

Hint:

Try to use recursion and notice that it should recurse with n - 2 instead of n - 1.
Show Company Tags
Show Tags
Show Similar Problems
Have you met this question in a real interview? Yes  
*/
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    
    private List<String> helper(int n, int m) {
        if (n == 0) {
            return new ArrayList<String>(Arrays.asList(""));    
        } else if (n == 1) {
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        
        List<String> list = helper(n - 2, m);
        List<String> res = new ArrayList<String>();
        
        for (int i = 0; i < list.size(); i++) {
            String cur = list.get(i);
            
            if (n != m) {
                res.add("0" + cur + "0");
            }
            
            res.add("1" + cur + "1");
            res.add("8" + cur + "8");
            res.add("6" + cur + "9");
            res.add("9" + cur + "6");
            
        }
        
        return res;
    }
}