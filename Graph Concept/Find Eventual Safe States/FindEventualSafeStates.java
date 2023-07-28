package graphs.problems;

import utils.Reader;
import java.io.IOException;
import graph.Graph;
import java.util.*;

// Leetcode Problem Link: https://leetcode.com/problems/find-eventual-safe-states/description/
public class FindEventualSafeStates {

    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();

        int[][] graph = {
            {1, 2, 3, 4},
            {1, 2},
            {3, 4},
            {0, 4},
            {}
        };

        FindEventualSafeStates obj = new FindEventualSafeStates();
        System.out.println(obj.eventualSafeNodes(graph));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Graph graphObj = new Graph(n);
        List<Integer> safeNodes = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<graph[i].length; j++) {
                graphObj.addDirectedEdge(i, graph[i][j]);
            }
        }

        int[] vis = new int[n];
        int[] unsafe = new int[n];

        for (int i=0; i<n; i++) {
            int[] cycle = new int[n];
            if(vis[i] == 0) {
                boolean isSafe = dfs(i, vis, cycle, unsafe, graphObj);
                unsafe[i] = (unsafe[i] == 1) ? 1 : (isSafe ? 0 : 1);
            }
        }

        for (int i=0; i<n; i++) {
            if (unsafe[i] == 0) {
                safeNodes.add(i);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    public boolean dfs (int node, int[] vis, int[] cycle, int[] unsafe, Graph graph) {
        if (cycle[node] == 1) {
            return false;
        }
        if (vis[node] == 1) {
            return true;
        }

        cycle[node] = 1;
        for (int adjNode : graph.getAdjacentNodes(node)) {
            boolean isSafe = dfs(adjNode, vis, cycle, unsafe, graph);
            unsafe[adjNode] = (unsafe[adjNode] == 1) ? 1 : (isSafe ? 0 : 1);
            if (!isSafe) {
                return false;
            }
        }

        cycle[node] = 0;
        vis[node] = 1;

        return true;
    }
}
