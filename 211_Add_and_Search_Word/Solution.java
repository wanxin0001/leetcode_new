/*
211. Add and Search Word - Data structure design  QuestionEditorial Solution  My Submissions
Total Accepted: 31385
Total Submissions: 155514
Difficulty: Medium
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

click to show hint.

You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
Hide Company Tags Facebook
Hide Tags Backtracking Trie Design
Hide Similar Problems (M) Implement Trie (Prefix Tree)
Have you met this question in a real interview? Yes  
*/
public class WordDictionary {
    private class TrieNode {
        public boolean isWord;
        public TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    } 
    
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int loc = word.charAt(i) - 'a';
            if (cur.children[loc] == null) {
                cur.children[loc] = new TrieNode();
            }
            
            cur = cur.children[loc];
        }
        
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if (word.length() == 0) {
            return false;
        }
        return helper(word, root);
    }
    
    private boolean helper(String word, TrieNode root) {
        if (word.length() == 0) {
            return root.isWord;
        }
        
        if (word.charAt(0) == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null && helper(word.substring(1), root.children[i])) { //root.children[i] != null necessary
                    return true;
                }
            }
        } else if (root.children[word.charAt(0) - 'a'] != null) { //root.children[i] != null  is necessary
            return helper(word.substring(1), root.children[word.charAt(0) - 'a']);
        }
        
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");