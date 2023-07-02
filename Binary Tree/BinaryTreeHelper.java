package binarytree;

// Class describing a Binary Tree.
public final class BinaryTreeHelper {
    // The method converts an array into a Binary Tree.
    // All the -1 values in the array are considered as a null node.
    // Eg. [3,2,3,-1,3,-1,1]
    public static BinaryTreeNode buildTree(int[] nodes, int index, int size) {
        if (index < size && nodes[index] != -1) {
            BinaryTreeNode node = new BinaryTreeNode(nodes[index]);
            node.left = buildTree(nodes, 2*index+1, size);
            node.right = buildTree(nodes, 2*index+2, size);
            return node;
        }
        return null;
    }

    private BinaryTreeHelper() {}
}