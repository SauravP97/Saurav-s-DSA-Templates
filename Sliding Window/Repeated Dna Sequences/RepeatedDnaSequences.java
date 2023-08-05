package slidingwindow.problems;

import utils.Reader;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.io.IOException;

// Problem link: https://leetcode.com/problems/repeated-dna-sequences/description/
class RepeatedDnaSequences {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        String str = reader.readLine();

        RepeatedDnaSequences obj = new RepeatedDnaSequences();
        System.out.println(Arrays.toString(obj.findRepeatedDnaSequences(str).toArray()));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        char[] dnas = s.toCharArray();
        HashSet<String> sequences = new HashSet<>();
        HashSet<String> repeatingSequences = new HashSet<>();

        int i = 0;

        while (i < s.length()) {
            if (i + 9 >= s.length()) {
                break;
            }
            String sequence = getSequence(dnas, i, i+9);
            if (sequences.contains(sequence)) {
                repeatingSequences.add(sequence);
            } else {
                sequences.add(sequence);
            }
            i++;
        }

        List<String> result = new ArrayList<>();
        result.addAll(repeatingSequences);
        return result;
    }

    public String getSequence(char[] dnas, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i=start; i<=end; i++) {
            sb.append(Character.toString(dnas[i]));
        }
        return sb.toString();
    }
}