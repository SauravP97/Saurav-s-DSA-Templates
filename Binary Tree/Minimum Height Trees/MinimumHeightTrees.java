package binarytree.problems;

import graph.Graph;
import utils.Reader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

// Leetcode Problem: https://leetcode.com/problems/minimum-height-trees/description/
public class MinimumHeightTrees {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[][] edges = new int[m][2];

        for (int i=0; i<m; i++) {
            edges[i][0] = reader.nextInt();
            edges[i][1] = reader.nextInt();
        }

        MinimumHeightTrees obj = new MinimumHeightTrees();
        System.out.println(Arrays.toString(obj.findMinHeightTrees(n, edges).toArray()));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Graph graph = new Graph(n);
        for (int i=0; i<edges.length; i++) {
            graph.addDirectedEdge(edges[i][0], edges[i][1]);
            graph.addDirectedEdge(edges[i][1], edges[i][0]);
        }

        int[] vis = new int[n];
        int[] depth = new int[n];
        dfs(0, graph, vis, depth);
        int endPoint1 = findMaxDepthNode(depth);

        initialiseDepth(depth);
        initialiseDepth(vis);
        dfs(endPoint1, graph, vis, depth);
        int endPoint2 = findMaxDepthNode(depth);

        initialiseDepth(vis);
        int[] parent = new int[n];
        parent[endPoint2] = -1;
        computeParent(endPoint2, graph, vis, parent);

        ArrayList<Integer> longestPath = new ArrayList<>();
        int cnode = endPoint1;
        while (cnode != -1) {
            longestPath.add(cnode);
            cnode = parent[cnode];
        }

        List<Integer> roots = new ArrayList<>();
        if (longestPath.size()%2 == 0) {
            roots.add(longestPath.get(longestPath.size()/2));
            roots.add(longestPath.get(longestPath.size()/2 - 1));
        } else {
            roots.add(longestPath.get(longestPath.size()/2));
        }

        return roots;
    }

    public void computeParent(int node, Graph graph, int[] vis, int[] parent) {
        vis[node] = 1;

        for (int adjNode : graph.getAdjacentNodes(node)) {
            if (vis[adjNode] == 0) {
                parent[adjNode] = node;
                computeParent(adjNode, graph, vis, parent);
            }
        }
    }

    public void dfs(int node, Graph graph, int[] vis, int[] depth) {
        vis[node] = 1;

        for (int adjNode : graph.getAdjacentNodes(node)) {
            if (vis[adjNode] == 0) {
                depth[adjNode] = depth[node] + 1;
                dfs(adjNode, graph, vis, depth);
            }
        }
    }

    public int findMaxDepthNode (int[] depth) {
        int endPoint = -1;
        int maxDepth = -1;
        for (int i=0; i<depth.length; i++) {
            if (maxDepth < depth[i]) {
                maxDepth = depth[i];
                endPoint = i;
            }
        }
        return endPoint;
    }

    public void initialiseDepth(int[] depth) {
        for (int i=0; i<depth.length; i++) {
            depth[i] = 0;
        }
    }
}