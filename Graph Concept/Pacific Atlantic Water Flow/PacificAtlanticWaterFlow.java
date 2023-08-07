package graphs.problems;

import utils.Reader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

// Problem link: https://leetcode.com/problems/pacific-atlantic-water-flow/description/ 
class PacificAtlanticWaterFlow {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int m = reader.nextInt();

        int[][] heights = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                heights[i][j] = reader.nextInt();
            }
        }

        PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
        System.out.println(obj.pacificAtlantic(heights));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];

        for (int i=0; i<m; i++) {
            // Water flowing from Pacific Ocean boundary
            bfs(0, i, n, m, heights, pacific);

            // Water flowing from Atlantic Ocean boudary
            bfs(n-1, i, n, m, heights, atlantic);
        }

        for (int i=0; i<n; i++) {
            // Water flowing from Pacific boundary
            bfs(i, 0, n, m, heights, pacific);

            // Water flowing from Atlantic Ocean boudary
            bfs(i, m-1, n, m, heights, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (atlantic[i][j] == 1 && pacific[i][j] == 1) {
                    List<Integer> indexes = new ArrayList<>();
                    indexes.add(i);
                    indexes.add(j);
                    result.add(indexes);
                }
            }
        }

        return result;
    }

    public void bfs(int row, int col, int n, int m, int[][] heights, int[][] vis) {
        if (vis[row][col] == 1) {
            return;
        }
        vis[row][col] = 1;
        
        // Go UP
        if (((row - 1) >= 0) && (heights[row][col] <= heights[row-1][col])) {
            bfs(row-1, col, n, m, heights, vis);
        }
        // Go DOWN
        if (((row + 1) < n) && (heights[row][col] <= heights[row+1][col])) {
            bfs(row+1, col, n, m, heights, vis);
        }
        // Go LEFT
        if (((col - 1) >= 0) && (heights[row][col] <= heights[row][col-1])) {
            bfs(row, col-1, n, m, heights, vis);
        }
        // Go Right
        if (((col + 1) < m) && (heights[row][col] <= heights[row][col+1])) {
            bfs(row, col+1, n, m, heights, vis);
        }
    }
}