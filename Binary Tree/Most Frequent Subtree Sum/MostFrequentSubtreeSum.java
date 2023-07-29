package binarytree.problems;

import binarytree.BinaryTreeNode;
import binarytree.BinaryTreeHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import utils.Reader;
import utils.Helper;
import java.io.IOException;

public class MostFrequentSubtreeSum {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int[] nodes = Helper.getIntArray(n, reader);

        BinaryTreeNode root = BinaryTreeHelper.buildTree(nodes, 0, n);

        MostFrequentSubtreeSum obj = new MostFrequentSubtreeSum();
        System.out.println(Arrays.toString(obj.findFrequentTreeSum(root))); 
    }

    public int[] findFrequentTreeSum(BinaryTreeNode root) {
        ArrayList<Integer> subRootSums = new ArrayList<>();
        int rootSum = findSubRootSums(root, subRootSums);

        int maxFrequency = 0;
        HashMap<Integer, Integer> sumsByFrequency = new HashMap<>();

        for (int subRootSum : subRootSums) {
            int curFreq = sumsByFrequency.getOrDefault(subRootSum, 0);
            curFreq++;
            maxFrequency = Math.max(maxFrequency, curFreq);
            sumsByFrequency.put(subRootSum, curFreq);
        }

        HashSet<Integer> result = new HashSet<>();

        for (int subRootSum : subRootSums) {
            if (sumsByFrequency.get(subRootSum) == maxFrequency) {
                result.add(subRootSum);
            }
        }

        int[] resArray = new int[result.size()];
        int count = 0;
        for (int subRootSum : result) {
            resArray[count] = subRootSum;
            count++;
        }

        return resArray;
    }

    public int findSubRootSums(BinaryTreeNode node, ArrayList<Integer> subRootSums) {
        if (node == null) {
            return 0;
        }

        int sum = node.value;
        sum += findSubRootSums(node.left, subRootSums);
        sum += findSubRootSums(node.right, subRootSums);

        subRootSums.add(sum);
        return sum;
    }
}