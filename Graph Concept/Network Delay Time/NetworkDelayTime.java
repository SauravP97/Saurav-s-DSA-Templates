package graphs.problems;

import binaryheap.HeapNode;
import binaryheap.BinaryMinHeap;
import java.util.HashMap;
import java.io.IOException;
import utils.Reader;
import graph.Graph;

// Leetcode Problem: https://leetcode.com/problems/network-delay-time/description/
public class NetworkDelayTime {
    public static final int MAX_VALUE = 100001;

    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int k = reader.nextInt();

        int m = reader.nextInt();
        int[][] times = new int[m][3];

        for (int i=0; i<m; i++) {
            times[i][0] = reader.nextInt();
            times[i][1] = reader.nextInt();
            times[i][2] = reader.nextInt();
        }

        NetworkDelayTime obj = new NetworkDelayTime();
        System.out.println(obj.networkDelayTime(times, n, k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Graph graph = new Graph(this.MAX_VALUE);
        HashMap<String, Integer> weightByEdge = new HashMap<>();

        for (int i=0; i<times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            graph.addDirectedEdge(u, v);
            weightByEdge.put(buildEdgeKey(u,v), times[i][2]);
        }

        return computeShortestPath(n, k, graph, weightByEdge);
    }

    public int computeShortestPath(int n, int k, Graph graph, HashMap<String, Integer> weightByEdge) {
        int[] vis = new int[n+1];
        int[] dist = new int[n+1];
        initialiseMaxDistance(dist);

        BinaryMinHeap minHeap = new BinaryMinHeap();
        minHeap.insert(k, 0);
        dist[k] = 0;

        while (!minHeap.isEmpty()) {
            HeapNode heapNode = minHeap.getMin();
            int node = heapNode.value;
            vis[node] = 1;

            for (int adjNode : graph.getAdjacentNodes(node)) {
                if (vis[adjNode] == 0) {
                    if (dist[adjNode] > (dist[node] + weightByEdge.get(buildEdgeKey(node, adjNode)))) {
                        dist[adjNode] = dist[node] + weightByEdge.get(buildEdgeKey(node, adjNode));
                        minHeap.insert(adjNode, dist[adjNode]);
                    }
                }
            }
        }

        int maxTime = 0;
        for (int i=1; i<=n; i++) {
            maxTime = Math.max(maxTime, dist[i]);
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
        }

        return maxTime;
    }

    public void initialiseMaxDistance(int[] dist) {
        for (int i=0; i<dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
    }

    public String buildEdgeKey(int u, int v) {
        return Integer.toString(u) + "--" + Integer.toString(v);
    }
}