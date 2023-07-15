package tries.problems;

import tries.Trie;

// Leetcode Problem: https://leetcode.com/problems/implement-trie-prefix-tree/description/
public class ImplementTrie {
    public static void main (String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }
}