package graph;

import java.util.ArrayList;

public class Graph {
    private ArrayList<Integer>[] graph;
    private int maxNodes;

    public Graph(int maxNodes) {
        this.maxNodes = maxNodes;
        allocateGraph();
    }

    private void allocateGraph() {
        this.graph = new ArrayList[maxNodes];
        for (int i=0; i<this.maxNodes; i++) {
            this.graph[i] = new ArrayList<Integer>();
        }
    }

    public ArrayList<Integer> getAdjacentNodes(int u) {
        return this.graph[u];
    }

    public void addDirectedEdge(int u, int v) {
        // Add a connection from u to v
        this.graph[u].add(v);
    }

    public boolean areConnected(int u, int v) {
        // Checks if there's an edge from u to v.
        return this.graph[u].contains(v);
    }
}