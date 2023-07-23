package graphs.problems;

import graph.Graph;
import utils.Reader;
import java.util.HashMap;
import java.io.IOException;

/** Leetcode Problem: https://leetcode.com/problems/minimum-cost-to-reach-destination-in-time/description/ */
public class MinimumCostToReachDestinationInTime {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int maxTime = reader.nextInt();

        int n = reader.nextInt();
        int m = reader.nextInt();
        int[][] edges = new int[m][3];

        for (int i=0; i<m; i++) {
            edges[i][0] = reader.nextInt();
            edges[i][1] = reader.nextInt();
            edges[i][2] = reader.nextInt();
        }

        int[] passingFees = new int[n];

        for (int i=0; i<n; i++) {
            passingFees[i] = reader.nextInt();
        }

        MinimumCostToReachDestinationInTime obj = new MinimumCostToReachDestinationInTime();
        System.out.println(obj.minCost(maxTime, edges, passingFees));
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        Graph graph = new Graph(n);
        HashMap<String, Integer> weightsByEdge = new HashMap<>();

        for (int i=0; i<edges.length; i++) {
            if (weightsByEdge.containsKey(getEdgeKey(edges[i][0], edges[i][1]))) {
                if (weightsByEdge.get(getEdgeKey(edges[i][0], edges[i][1])) > edges[i][2]) {
                    weightsByEdge.put(getEdgeKey(edges[i][0], edges[i][1]), edges[i][2]);
                    weightsByEdge.put(getEdgeKey(edges[i][1], edges[i][0]), edges[i][2]);
                }
            } else {
                graph.addDirectedEdge(edges[i][0], edges[i][1]);
                graph.addDirectedEdge(edges[i][1], edges[i][0]);
                weightsByEdge.put(getEdgeKey(edges[i][0], edges[i][1]), edges[i][2]);
                weightsByEdge.put(getEdgeKey(edges[i][1], edges[i][0]), edges[i][2]);
            }
        }

        int[] minTime = new int[n];
        int[] vis = new int[n];
        initialiseTime(minTime);

        BinaryMinModifiedHeap heap = new BinaryMinModifiedHeap();
        heap.insert(0, passingFees[0], 0);
        minTime[0] = 0;

        while (!heap.isEmpty()) {
            HeapNode node = heap.getMin();

            if (node.value == n-1) {
                return node.comparisonValue;
            }

            for (int adjNode : graph.getAdjacentNodes(node.value)) {
                int timeTaken = node.time + weightsByEdge.get(getEdgeKey(node.value, adjNode));
                int fees = node.comparisonValue + passingFees[adjNode];
                if (timeTaken >= minTime[adjNode] || timeTaken > maxTime) {
                    continue;
                }
                minTime[adjNode] = timeTaken;
                heap.insert(adjNode, fees, timeTaken);
            }
        }

        return -1;
    }

    public String getEdgeKey(int u, int v) {
        return Integer.toString(u) + "--" + Integer.toString(v);
    }

    public void initialiseTime(int[] minFees) {
        for (int i=0; i<minFees.length; i++) {
            minFees[i] = Integer.MAX_VALUE;
        }
    }
}

class HeapNode {
    public int value;
    public int comparisonValue;
    public int time;

    public HeapNode (int value, int comparisonValue, int time) {
        this.value = value;
        this.comparisonValue = comparisonValue;
        this.time = time;
    }
}

class BinaryModifiedHeap {
    static final int MAX_SIZE = 4*100001;

    HeapNode[] heapNodes;
    int size;

    public BinaryModifiedHeap() {
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

class BinaryMinModifiedHeap extends BinaryModifiedHeap {
    
    public BinaryMinModifiedHeap() {
        super();
    }

    public void insert(int value, int comparisonValue, int time) {
        HeapNode heapNode = new HeapNode(value, comparisonValue, time);
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
            if (heapNodes[parentIndex].comparisonValue == heapNodes[currentIndex].comparisonValue 
                && heapNodes[parentIndex].time <= heapNodes[currentIndex].time) {
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

        if (leftIndex < this.size 
            && ((heapNodes[maxIndex].comparisonValue > heapNodes[leftIndex].comparisonValue)
                || ((heapNodes[maxIndex].comparisonValue == heapNodes[leftIndex].comparisonValue) 
                    && (heapNodes[maxIndex].time > heapNodes[leftIndex].time)))) {
            maxIndex = leftIndex;
        }

        if (rightIndex < this.size 
            && ((heapNodes[maxIndex].comparisonValue > heapNodes[rightIndex].comparisonValue)
                || ((heapNodes[maxIndex].comparisonValue == heapNodes[rightIndex].comparisonValue) 
                    && (heapNodes[maxIndex].time > heapNodes[rightIndex].time)))) {
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