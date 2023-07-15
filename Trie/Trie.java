package tries;

public class Trie {
    TrieNode rootNode;

    class TrieNode {
        private TrieNode[] nodes;
        private boolean isWord;
        
        public TrieNode () {
            this.nodes = new TrieNode[26];
            this.isWord = false;
        }

        public boolean hasNodeAt(int index) {
            return (this.nodes[index] != null);
        }

        public TrieNode getTrieNode(int index) {
            return this.nodes[index];
        }

        public TrieNode setTrieNode(int index, TrieNode node) {
            this.nodes[index] = node;
            return node;
        }

        public void setIsWord() {
            this.isWord = true;
        }

        public boolean isWord() {
            return this.isWord;
        }
    }

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