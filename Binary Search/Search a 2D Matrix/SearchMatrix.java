package binarysearch.problems;

import utils.Reader;
import java.io.IOException;

// Problem link: https://leetcode.com/problems/search-a-2d-matrix/description/
class SearchMatrix {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int m = reader.nextInt();
        int target = reader.nextInt();
        int[][] matrix = new int[n][m];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                matrix[i][j] = reader.nextInt();
            }
        }

        SearchMatrix obj = new SearchMatrix();
        System.out.println(obj.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        return binarySearchOnMatrix(matrix, 0, n*m - 1, target);
    }

    public boolean binarySearchOnMatrix(int[][] matrix, int start, int end, int target) {
        if (start <= end) {
            int mid = (start + end)/2;
            int row = mid/matrix[0].length;
            int col = mid%matrix[0].length;

            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                return binarySearchOnMatrix(matrix, mid+1, end, target);
            }
            if (matrix[row][col] > target) {
                return binarySearchOnMatrix(matrix, start, mid-1, target);
            }
        }
        return false;
    }
}