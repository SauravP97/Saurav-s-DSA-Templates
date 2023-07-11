package graphs.problems;

import graph.Graph;
import utils.Reader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// Leetcode Problem: https://leetcode.com/problems/evaluate-division/description/
class EvaluateDivision {
    Graph graph;

    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = Integer.parseInt(reader.readLine());
        int ch = 0;
        ArrayList<ArrayList<String>> equations = new ArrayList<ArrayList<String>>();
        double[] values = new double[n];
        EvaluateDivision obj = new EvaluateDivision();

        while (ch < n) {
            String nodeStr = reader.readLine();
            String[] nodes = nodeStr.split(" ");
            ArrayList<String> nodesList = new ArrayList<>();
            nodesList.add(nodes[0]);
            nodesList.add(nodes[1]);
            equations.add(nodesList);
            values[ch] = Double.parseDouble(nodes[2]);
            ch++;
        }

        int m = Integer.parseInt(reader.readLine());
        ArrayList<ArrayList<String>> queries = new ArrayList<ArrayList<String>>();
        ch = 0;

        while (ch < m) {
            String nodeStr = reader.readLine();
            String[] nodes = nodeStr.split(" ");
            ArrayList<String> nodesList = new ArrayList<>();
            nodesList.add(nodes[0]);
            nodesList.add(nodes[1]);
            queries.add(nodesList);
            ch++;
        }

        System.out.print(Arrays.toString(obj.calcEquation(equations, values, queries)));
    }

    public double[] calcEquation(ArrayList<ArrayList<String>> equations, double[] values, ArrayList<ArrayList<String>> queries) {
        this.graph = new Graph(100);
        HashMap<String, Integer> indexByValue = new HashMap<String, Integer>();
        HashMap<String, Double> weightByEdge = new HashMap<String, Double>();
        int reservedIndexes = 0;
        int index = 0;

        for (ArrayList<String> equation : equations) {
            String node1 = equation.get(0);
            String node2 = equation.get(1);
            int nodeIndex1 = -1;
            int nodeIndex2 = -1;
            if (indexByValue.containsKey(node1)) {
                nodeIndex1 = indexByValue.get(node1);
            } else {
                indexByValue.put(node1, reservedIndexes);
                nodeIndex1 = reservedIndexes;
                reservedIndexes++;
            }
            if (indexByValue.containsKey(node2)) {
                nodeIndex2 = indexByValue.get(node2);
            } else {
                indexByValue.put(node2, reservedIndexes);
                nodeIndex2 = reservedIndexes;
                reservedIndexes++;
            }
            double value = values[index];
            this.graph.addDirectedEdge(nodeIndex1, nodeIndex2);
            weightByEdge.put(computeEdge(nodeIndex1, nodeIndex2), value);
            this.graph.addDirectedEdge(nodeIndex2, nodeIndex1);
            weightByEdge.put(computeEdge(nodeIndex2, nodeIndex1), 1.0/value);
            index++;
        }

        double[] results = new double[queries.size()];
        index = 0;

        for (ArrayList<String> query : queries) {
            String node1 = query.get(0);
            String node2 = query.get(1);
            if (!indexByValue.containsKey(node1) || !indexByValue.containsKey(node2)) {
                results[index] = -1.0;
                index++;
                continue;
            }
            int[] vis = new int[100];
            double result = dfs(indexByValue.get(node1), indexByValue.get(node2), vis, weightByEdge, 1.0);
            results[index] = result;
            index++;
        }

        return results;
    }

    public double dfs(int node, int dest, int[] vis, HashMap<String, Double> weightByEdge, double weight) {
        if (node == dest) {
            return weight;
        }
        vis[node] = 1;
        for (int adjNode : this.graph.getAdjacentNodes(node)) {
            if (vis[adjNode] == 0) {
                double curWeight = weight * weightByEdge.get(computeEdge(node, adjNode));
                double computedWeight = dfs(adjNode, dest, vis, weightByEdge, curWeight);
                if (computedWeight != -1.0) {
                    return computedWeight;
                }
            }
        }
        return -1.0;
    }

    public String computeEdge(int node1, int node2) {
        return Integer.toString(node1) + "---" + Integer.toString(node2);
    }
}