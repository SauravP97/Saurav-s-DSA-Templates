package binarytree.problems;

// LeetCode Problem: https://leetcode.com/problems/house-robber-iii/ 
// Note: We will take node with null values to be -1 instead.
import utils.Reader;
import utils.Helper;
import binarytree.BinaryTreeNode;
import binarytree.BinaryTreeHelper;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class HouseRobber3 {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int size = reader.nextInt();
        int[] nodes = Helper.getIntArray(size, reader);

        BinaryTreeNode root = BinaryTreeHelper.buildTree(nodes, 0, nodes.length);

        HouseRobber3 houseRobber3 = new HouseRobber3();
        System.out.println(houseRobber3.rob(root));
    }

    public int rob(BinaryTreeNode root) {
        int[][] maxCosts = maxCost(root);
        return Math.max(maxCosts[0][0], maxCosts[0][1]);
    }

    private static int[][] maxCost(BinaryTreeNode node) {
        int[][] leftCosts = new int[1][2];
        int[][] rightCosts = new int[1][2];
        int[][] currentCosts = new int[1][2];

        if (node.left != null) {
            leftCosts = maxCost(node.left); 
        }
        if (node.right != null) {
            rightCosts = maxCost(node.right);
        }

        int robbed = node.value + leftCosts[0][0] + rightCosts[0][0];
        int notRobbed = Math.max(leftCosts[0][0], leftCosts[0][1]) + Math.max(rightCosts[0][0], rightCosts[0][1]);
        currentCosts[0][0] = notRobbed;
        currentCosts[0][1] = robbed;

        return currentCosts;
    }
}