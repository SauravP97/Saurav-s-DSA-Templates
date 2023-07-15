package dp.problems;

import utils.Reader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

// Leetcode Problem: https://leetcode.com/problems/word-break/description/
class WordBreak {
    int[] mem = new int[300];
    boolean[] res = new boolean[300];

    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        String str = reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        List<String> words = new ArrayList<String>();

        for (int i=0; i<n; i++) {
            words.add(reader.readLine());
        }

        WordBreak obj = new WordBreak();
        System.out.println(obj.wordBreak(str, words));
    }

    public boolean wordBreak(String str, List<String> words) {
        return wordBreakRec(str, words, 0);
    }

    public boolean wordBreakRec(String str, List<String> words, int offset) {
        if (str.length() == 0) {
            return true;
        }
        boolean posi = false;
        for (int i=0; i<str.length(); i++) {
            if (mem[offset + i] == 1) {
                posi = res[offset + i];
            }
            else if (contains(words, str.substring(0, i+1))) {
                posi = wordBreakRec(str.substring(i+1, str.length()), words, offset + i);
                mem[offset + i] = 1;
                res[offset + i] = posi;
            }
            if (posi) {
                break;
            }
        }
        return posi;
    }

    public boolean contains(List<String> words, String word) {
        for (int i=0; i<words.size(); i++) {
            if (words.get(i).equals(word)) {
                return true;
            }
        }
        return false;
    }
}