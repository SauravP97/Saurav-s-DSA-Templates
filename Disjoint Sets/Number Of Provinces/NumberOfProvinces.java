package disjointsets.problems;

import disjointsets.DisjointSet;
import utils.Reader;
import utils.Helper;
import java.io.IOException;
import java.util.HashSet;

public class NumberOfProvinces {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int[][] mat = Helper.getIntMatrix(n, reader);

        NumberOfProvinces obj = new NumberOfProvinces();

        System.out.println(obj.findCircleNum(mat));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet disjointset = new DisjointSet(n);

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (isConnected[i][j] == 1) {
                    disjointset.union(i, j);
                }
            }
        }

        HashSet<Integer> components = new HashSet<>();
        for (int i=0; i<n; i++) {
            components.add(disjointset.find(i));
        }

        return components.size();
    }
}