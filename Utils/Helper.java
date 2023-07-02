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
    // A private constructor, this class not needed to be instantiated.
    private Helper() {};
}