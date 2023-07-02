package binarytree;

// Class describing the node of a Binary Tree.
public class BinaryTreeNode {
    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNode(int value, BinaryTreeNode left) {
        this.value = value;
        this.left = left;
    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}