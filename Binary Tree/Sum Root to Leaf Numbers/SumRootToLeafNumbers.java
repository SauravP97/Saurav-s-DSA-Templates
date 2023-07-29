package binarytree.problems;

import binarytree.BinaryTreeNode;
import binarytree.BinaryTreeHelper;
import java.util.ArrayList;
import utils.Reader;
import utils.Helper;
import java.io.IOException;

// Leetcode problem: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
public class SumRootToLeafNumbers {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int[] nodes = Helper.getIntArray(n, reader);

        BinaryTreeNode root = BinaryTreeHelper.buildTree(nodes, 0, n);

        SumRootToLeafNumbers obj = new SumRootToLeafNumbers();
        System.out.println(obj.sumNumbers(root));        
    }

    public int sumNumbers(BinaryTreeNode root) {
        if (root.left == null && root.right == null) {
            return root.value;
        }
        ArrayList<Integer> numbers = new ArrayList<>();
        dfs(root, 0, numbers, true);
        
        int sum = 0;
        for (int number : numbers) {
            System.out.println("Number: " + number);
            sum += number;
        }

        return sum;
    }

    public void dfs(BinaryTreeNode node, int num, ArrayList<Integer> numbers, boolean isRoot) {
        if (node == null) {
            numbers.add(num);
            return;
        }
        int number = (num * 10) +  node.value;
        if (!isRoot && node.left == null && node.right == null) {
            numbers.add(number);
        }
        if (node.left != null) {
            dfs(node.left, number, numbers, false);
        }
        if (node.right != null) {
            dfs(node.right, number, numbers, false);
        }
    }
}