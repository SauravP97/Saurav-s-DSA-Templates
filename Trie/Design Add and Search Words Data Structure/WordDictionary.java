package tries.problems;

import tries.Trie;
import tries.TrieNode;
import java.util.ArrayList;

// Problem link: https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
public class WordDictionary {
    private DictionaryTrie trie;

    public WordDictionary() {
        trie = new DictionaryTrie();
    }

    public void addWord (String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.patternSearch(word);
    }

    public static void main (String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}

class DictionaryTrie extends Trie {
    DictionaryTrie () {
        super();
    }

    public void insert (String word) {
        super.insert(word);
    }

    public boolean patternSearch (String word) {
        ArrayList<TrieNode> currentNodes = new ArrayList<>();
        currentNodes.add(this.rootNode);

        for (int i=0; i<word.length(); i++) {
            int asci = (int) (word.charAt(i) - 97);
            ArrayList<TrieNode> matchedNodes = new ArrayList<>();
            //System.out.println(word.charAt(i));
            if ((int)word.charAt(i) == 46) {
                // If character is '.'
                for (TrieNode currentNode: currentNodes) {
                    TrieNode[] childNodes = currentNode.getTrieNodes();
                    for (TrieNode childNode : childNodes) {
                        if (childNode != null) {
                            matchedNodes.add(childNode);
                        }
                    }
                }
            }
            else {
                for (TrieNode currentNode : currentNodes) {
                    if (currentNode.hasNodeAt(asci)) {
                        matchedNodes.add(currentNode.getTrieNode(asci));
                    }
                }
                if (matchedNodes.size() == 0) {
                    return false;
                }
            }
            currentNodes = matchedNodes;
        }
        for (TrieNode currentNode : currentNodes) {
            if (currentNode.isWord()) {
                return true;
            }
        }
        return false;
    }
}