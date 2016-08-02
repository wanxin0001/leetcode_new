/*
187. Repeated DNA Sequences  QuestionEditorial Solution  My Submissions
Total Accepted: 50062
Total Submissions: 185135
Difficulty: Medium
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        
        if (s == null || s.length() == 0) {
            return result;
        }
        
        HashSet<Integer> hash = new HashSet<Integer>();
        HashSet<String> set = new HashSet<String>();
        
        for (int i = 9; i < s.length(); i++) {
            String sub = s.substring(i - 9, i + 1);
            int val = encode(sub);
            if (hash.contains(val)) {
                set.add(sub);
            } else {
                hash.add(val);
            }
        }
        
        for (String str : set) {
            result.add(str);
        }
        
        return result;
    }
    
    private int encode(String str) {
        int val = 0;
        for (int i = 0; i < 10; i++) {
            val *= 4;
            char s = str.charAt(i);
            if (s == 'A') {
                continue;
            } else if (s == 'C') {
                val += 1;
            } else if (s == 'G') {
                val += 2;
            } else {
                val += 3;
            }
        }
        return val;
    }
}