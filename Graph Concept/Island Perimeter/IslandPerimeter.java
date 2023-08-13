package graph.problems;

import java.io.IOException;
import utils.Reader;

// Leetcode problem: https://leetcode.com/problems/island-perimeter/description/
class IslandPerimeter {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[][] grid = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                grid[i][j] = reader.nextInt();
            }
        }

        IslandPerimeter obj = new IslandPerimeter();
        System.out.println(obj.islandPerimeter(grid));
    }

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                perimeter += computePerimeter(grid, i, j, grid.length, grid[0].length);
            }
        }

        return perimeter;
    }

    public int computePerimeter(int[][] grid, int i, int j, int n, int m) {
        int perimeter = 0;

        if (grid[i][j] == 0) {
            return 0;
        }
        if (i == 0 || (i-1 >= 0 && grid[i-1][j] == 0)) {
            perimeter++;
        }
        if (i == n-1 || (i+1 < n && grid[i+1][j] == 0)) {
            perimeter++;
        }
        if (j == 0 || (j-1 >= 0 && grid[i][j-1] == 0)) {
            perimeter++;
        }
        if (j == m-1 || (j+1 < m && grid[i][j+1] == 0)) {
            perimeter++;
        }

        return perimeter;
    }
}