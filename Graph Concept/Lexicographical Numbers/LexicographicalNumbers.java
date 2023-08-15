package graphs.problems;

import graph.Graph;
import utils.Reader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

// Problem Link: https://leetcode.com/problems/lexicographical-numbers/description/
class LexicographicalNumbers {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int n = reader.nextInt();

        LexicographicalNumbers obj = new LexicographicalNumbers();

        System.out.println(obj.lexicalOrder(n));   
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i=1; i<10; i++) {
            dfs(i, n, result);
        }

        return result;
    }

    public void dfs(int digit, int n, List<Integer> result) {
        if (digit > n) {
            return;
        }
        result.add(digit);
        for (int i=0; i<10; i++) {
            dfs(digit*10 + i, n, result);
        }
    }
}