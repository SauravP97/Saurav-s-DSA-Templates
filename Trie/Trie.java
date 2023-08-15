package tries;

import tries.TrieNode;

public class Trie {
    public TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = this.rootNode;

        for (int i=0; i<word.length(); i++) {
            int asci = (int) (word.charAt(i) - 97);
            if (currentNode.hasNodeAt(asci)) {
                currentNode = currentNode.getTrieNode(asci);
            } else {
                currentNode = currentNode.setTrieNode(asci, new TrieNode());
            }
        }
        currentNode.setIsWord();
    }

    public boolean search (String word) {
        TrieNode currentNode = this.rootNode;
        for (int i=0; i<word.length(); i++) {
            int asci = (int) (word.charAt(i) - 97);
            if (!currentNode.hasNodeAt(asci)) {
                return false;
            }
            currentNode = currentNode.getTrieNode(asci);
        }
        return currentNode.isWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = this.rootNode;
        for (int i=0; i<prefix.length(); i++) {
            int asci = (int) (prefix.charAt(i) - 97);
            if (!currentNode.hasNodeAt(asci)) {
                return false;
            }
            currentNode = currentNode.getTrieNode(asci);
        }
        return true;
    }
}