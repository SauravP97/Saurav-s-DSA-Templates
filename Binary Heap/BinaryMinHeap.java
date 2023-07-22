package binaryheap;

import binaryheap.HeapNode;
import binaryheap.BinaryHeap;

public class BinaryMinHeap extends BinaryHeap {
    
    public BinaryMinHeap() {
        super();
    }

    public void insert(int value, int comparisonValue) {
        HeapNode heapNode = new HeapNode(value, comparisonValue);
        if (this.size >= this.MAX_SIZE) {
            throw new IllegalStateException(
                "Size of the Heap exceeding the max size of: " + this.MAX_SIZE);
        }
        heapNodes[this.size] = heapNode;
        this.size++;

        int currentIndex = (this.size - 1);
        while (currentIndex != 0) {
            int parentIndex = getParent(currentIndex);
            if (heapNodes[parentIndex].comparisonValue < heapNodes[currentIndex].comparisonValue) {
                break;
            }
            HeapNode tempNode = heapNodes[parentIndex];
            heapNodes[parentIndex] = heapNodes[currentIndex];
            heapNodes[currentIndex] = tempNode;
            currentIndex = parentIndex; 
        }
    }

    public HeapNode getMin() {
        HeapNode maxNode = heapNodes[0];
        heapNodes[0] = heapNodes[this.size-1];
        this.size--;

        minHeapify(0);
        
        return maxNode;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    private void minHeapify (int currentIndex) {
        int leftIndex = getLeftIndex(currentIndex);
        int rightIndex = getRightIndex(currentIndex);
        int maxIndex = currentIndex;

        if (leftIndex < this.size && heapNodes[maxIndex].comparisonValue > heapNodes[leftIndex].comparisonValue) {
            maxIndex = leftIndex;
        }

        if (rightIndex < this.size && heapNodes[maxIndex].comparisonValue > heapNodes[rightIndex].comparisonValue) {
            maxIndex = rightIndex;
        }

        if (maxIndex != currentIndex) {
            HeapNode tempNode = heapNodes[currentIndex];
            heapNodes[currentIndex] = heapNodes[maxIndex];
            heapNodes[maxIndex] = tempNode;
            minHeapify(maxIndex);
        }
    }
}