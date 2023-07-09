package graph.problems;

import graph.Graph;
import utils.Reader;
import java.io.IOException;
import java.util.ArrayList;

// Leetcode Problem: https://leetcode.com/problems/course-schedule/description/
class CourseSchedule {
    Graph graph;

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int m = reader.nextInt();

        int[][] prereq = new int[m][2];

        for (int i=0; i<m; i++) {
            prereq[i][0] = reader.nextInt();
            prereq[i][1] = reader.nextInt();
        }

        CourseSchedule obj = new CourseSchedule();
        System.out.print(obj.canFinish(n, prereq));
    }

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        int m = prerequisites.length;
        this.graph = new Graph(numCourses);
        int[] blocked = new int[numCourses];

        for (int i=0; i<m; i++) {
            this.graph.addDirectedEdge(prerequisites[i][1], prerequisites[i][0]);
            blocked[prerequisites[i][0]] = 1;
        }

        int[] done = new int[numCourses];
        boolean cycle = false;

        for (int i=0; i<numCourses; i++) {
            if (done[i] == 0 && this.graph.getAdjacentNodes(i).size() > 0) {
                int[] vis = new int[numCourses];
                cycle = dfs(i, vis, numCourses, done);
            }
            if (cycle) {
                break;
            }
        }

        return !cycle;
    }

    private boolean dfs(int node, int[] vis, int numCourses, int[] done) {
        if (done[node] == 1) {
            return false;
        } 
        vis[node] = 1;
        done[node] = 1;
        ArrayList<Integer> adjacentNodes = this.graph.getAdjacentNodes(node);
        for (int adjNode : adjacentNodes) {
            if (vis[adjNode] == 1) {
                // Visiting the already visited node again.
                // It's a cycle.
                return true;
            }
            boolean gotCycle = dfs(adjNode, vis, numCourses, done);
            if (gotCycle) {
                return true;
            }
        }
        vis[node] = 0;
        return false;
    }
}