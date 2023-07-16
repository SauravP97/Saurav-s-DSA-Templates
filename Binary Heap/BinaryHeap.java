package binaryheap;

public class BinaryHeap {
    static final int MAX_SIZE = 4*100001;

    HeapNode[] heapNodes;
    int size;

    public BinaryHeap() {
        this.size = 0;
        this.heapNodes = new HeapNode[this.MAX_SIZE];
    }

    int getLeftIndex(int index) {
        return (2*index + 1);
    }

    int getRightIndex(int index) {
        return (2*index + 2);
    }

    int getParent(int index) {
        return ((index-1)/2);
    }
}