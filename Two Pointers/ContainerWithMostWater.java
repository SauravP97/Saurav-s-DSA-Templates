import utils.Reader;
import utils.Helper;
import java.io.IOException;

// Leetcode Problem: https://leetcode.com/problems/container-with-most-water/description/
class ContainerWithMostWater {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();

        int n = reader.nextInt();
        int[] arr = Helper.getIntArray(n, reader);

        int p1 = 0;
        int p2 = n-1;
        int result = Math.min(arr[p1], arr[p2]) * (p2 - p1);

        while (p1 < p2) {
            if (arr[p1] < arr[p2]) {
                p1++;
            } else {
                p2--;
            }
            result = Math.max(result, Math.min(arr[p1], arr[p2]) * (p2-p1));
        }
        
        System.out.print(result);
    }
}
