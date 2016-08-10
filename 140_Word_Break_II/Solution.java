/*
140. Word Break II  QuestionEditorial Solution  My Submissions
Total Accepted: 62270
Total Submissions: 301485
Difficulty: Hard
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].

Show Company Tags
Show Tags
Have you met this question in a real interview? Yes  
*/
/*
Reference: http://www.jiuzhang.com/solutions/word-break-ii/
*/
public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return result;
        }
        
        boolean[][] isWord = getIsWord(s, wordDict);
        boolean[] f = getPossibleArray(isWord);
        
        List<String> tmp = new ArrayList<String>();
        dfs(result, tmp, isWord, f, s, 0);
        
        return result;
    }
    
    private void dfs(List<String> result, List<String> tmp, boolean[][] isWord, boolean[] f, String s, int idx) {
        if (!f[idx]) {
            return;
        }
        
        if (idx == s.length()) {
            String str = "";
            for (int i = 0; i < tmp.size(); i++) {
                str += tmp.get(i);
                if (i != tmp.size() - 1) {
                    str += " ";
                }
            }
            result.add(str);
            return;
        }
        
        for (int i = idx; i < s.length(); i++) {
            if (!isWord[idx][i]) {
                continue;
            }
            
            tmp.add(s.substring(idx, i + 1));
            dfs(result, tmp, isWord, f, s, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
    
    private boolean[] getPossibleArray(boolean[][] isWord) {
        int size = isWord.length;
        boolean[] f = new boolean[size + 1];
        f[size] = true;
        
        for (int i = size - 1; i >= 0; i--) {
            for (int j = i; j <= size - 1; j++) {
                if (isWord[i][j] && f[j + 1]) {
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f;
    }
    
    private boolean[][] getIsWord(String s, Set<String> wordDict) {
        int max = 0;
        for (String str : wordDict) {
            max = Math.max(str.length(), max);
        }
        
        boolean[][] f = new boolean[s.length()][s.length()];
        int size = s.length();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                f[i][j] = wordDict.contains(s.substring(i, j + 1));
            }
        }
        
        return f;
    }
}