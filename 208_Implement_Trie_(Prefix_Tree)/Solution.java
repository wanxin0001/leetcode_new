/*
208. Implement Trie (Prefix Tree)  QuestionEditorial Solution  My Submissions
Total Accepted: 45182
Total Submissions: 176810
Difficulty: Medium
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

Hide Company Tags Google Uber Facebook Twitter Microsoft Bloomberg
Hide Tags Design Trie
Hide Similar Problems (M) Add and Search Word - Data structure design
Have you met this question in a real interview? Yes  No
Discuss Pick One


*/
/*
Reference: https://discuss.leetcode.com/topic/19221/ac-java-solution-simple-using-single-array/3
*/
class TrieNode {
    // Initialize your data structure here.
    boolean isWord;
    TrieNode[] children;
    public TrieNode() {
        isWord = false;
        children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        
        cur.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int loc = word.charAt(i) - 'a';
            if (cur.children[loc] == null) {
                return false; 
            } else {
                cur = cur.children[loc];
            }
        }
        
        return cur.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        
        for (int i = 0; i < prefix.length(); i++) {
            int loc = prefix.charAt(i) - 'a';
            if (cur.children[loc] == null) {
                return false;
            }
            
            cur = cur.children[loc];
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");