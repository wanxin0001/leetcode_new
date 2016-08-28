/*
212. Word Search II  QuestionEditorial Solution  My Submissions
Total Accepted: 25982
Total Submissions: 124706
Difficulty: Hard
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

click to show hint.

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.

Hide Company Tags Microsoft Google Airbnb
Hide Tags Backtracking Trie
Hide Similar Problems (M) Word Search
Have you met this question in a real interview? Yes  
*/
/*
https://discuss.leetcode.com/topic/33246/java-15ms-easiest-solution-100-00/2
*/
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<String>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(result, board, i, j, root);
            }
        }
        
        return result;
    }
    
    private void dfs(List<String> result, char[][] board, int i, int j, TrieNode root) {
        char c = board[i][j];
        if (c == '#' || root.children[c - 'a'] == null) {
            return;
        }
        root = root.children[c - 'a'];
        
        if (root.word != null) {
            result.add(root.word);
            root.word = null; //necessary
        }
        
        board[i][j] = '#';
        if (j > 0) {
            dfs(result, board, i, j - 1, root);
        }
        
        if (i > 0) {
            dfs(result, board, i - 1, j, root);
        }
        
        if (i < board.length - 1) {
            dfs(result, board, i + 1, j, root);
        }
        
        if (j < board[0].length - 1) {
            dfs(result, board, i, j + 1, root);
        }
        
        board[i][j] = c;
        
    }
    
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int loc = word.charAt(i) - 'a';
                if (cur.children[loc] == null) {
                    cur.children[loc] = new TrieNode();
                }
                cur = cur.children[loc];
            }
            
            cur.word = word;
        }
        return root;
    }
    
    private class TrieNode {
        String word;
        TrieNode[] children;
        public TrieNode() {
            word = null;
            children = new TrieNode[26];
        }
    }
}