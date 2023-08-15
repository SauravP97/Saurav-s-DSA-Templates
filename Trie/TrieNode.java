package tries;

public class TrieNode {
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

    public TrieNode[] getTrieNodes() {
        return this.nodes;
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