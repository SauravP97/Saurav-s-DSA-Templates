package utils;

import utils.Reader;
import java.io.IOException;

// Standard Helper methods.
public final class Helper {

    public static int[] getIntArray(int size, Reader reader) throws IOException {
        int[] arr = new int[size];
        for (int i=0; i<size; i++) {
            arr[i] = reader.nextInt();
        }
        return arr;
    }

    public static int[][] getIntMatrix(int size, Reader reader) throws IOException {
        int[][] mat = new int[size][size];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                mat[i][j] = reader.nextInt();
            }
        }
        return mat;
    }

    // A private constructor, this class not needed to be instantiated.
    private Helper() {};
}