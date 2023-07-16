package binaryheap.problems;

import binaryheap.BinaryMaxHeap;
import binaryheap.HeapNode;
import java.util.HashMap;
import java.util.Arrays;
import java.io.IOException;
import java.util.Map;
import utils.Reader;
import utils.Helper;

public class TopKFrequentElements {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int[] nums = Helper.getIntArray(n, reader);
        int k = reader.nextInt();
        
        TopKFrequentElements obj = new TopKFrequentElements();
        System.out.println(Arrays.toString(obj.topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freuqnecyByValue = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (freuqnecyByValue.containsKey(nums[i])) {
                freuqnecyByValue.put(nums[i], freuqnecyByValue.get(nums[i]) + 1);
            } else {
                freuqnecyByValue.put(nums[i], 1);
            }
        }

        BinaryMaxHeap maxHeap = new BinaryMaxHeap();
        for (Map.Entry<Integer, Integer> entry : freuqnecyByValue.entrySet()) {
            maxHeap.insert(entry.getKey(),  entry.getValue());
        }

        int[] topValues = new int[k];
        for (int i=0; i<k; i++) {
            topValues[i] = maxHeap.getMax().value;
        }

        return topValues;
    }
}