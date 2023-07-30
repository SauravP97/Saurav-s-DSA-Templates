package dp.problems;

import utils.Reader;
import java.io.IOException;

// Leetcode Problem: https://leetcode.com/problems/edit-distance/description/
public class EditDistance {
    public static void main (String[] args) throws IOException {
        Reader reader = new Reader();
        String word1 = reader.readLine();
        String word2 = reader.readLine();

        EditDistance obj = new EditDistance();
        System.out.println(obj.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        if (word2.length() == 0) {
            return word1.length();
        }
        if (word1.length() == 0) {
            return word2.length();
        }
        int[][] dp = new int[word1.length()][word2.length()];

        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[i].length; j++) {
                int charAdded = Integer.MAX_VALUE;
                int charDeleted = Integer.MAX_VALUE;
                int charReplaced = Integer.MAX_VALUE;

                if (j>0) {
                    charAdded = dp[i][j-1] + 1;
                }
                
                if (i>0) {
                    charDeleted = dp[i-1][j] + 1;
                } else {
                    charDeleted = j+1;
                }

                if (i>0 && j>0) {
                    charReplaced = dp[i-1][j-1] + ((word1.charAt(i) == word2.charAt(j)) ? 0 : 1);
                }
                else if (i==0 && j==0) {
                    charReplaced = (word1.charAt(i) == word2.charAt(j)) ? 0 : 1;
                }
                else if (j == 0 && i > 0) {
                    // Delete the all the previous letters before i th index from word1 
                    charReplaced = ((word1.charAt(i) == word2.charAt(j)) ? 0 : 1) + i;
                }
                else if (j > 0 && i == 0) {
                    // Insert j characters before word1
                    charReplaced = ((word1.charAt(i) == word2.charAt(j)) ? 0 : 1) + j;
                }

                dp[i][j] = Math.min(Math.min(charAdded, charDeleted), charReplaced);
            }
        }
        
       printDp(dp);
       int res = Integer.MAX_VALUE;

        for (int i=0; i<word1.length(); i++) {
            res = Math.min(res, dp[i][word2.length() -1]) + (word1.length() - i - 1);
        }

        return res;
    }

    public void initializeDp(int[][] dp) {
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[i].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public void printDp(int[][] dp) {
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[i].length; j++) {
                System.out.print(dp[i][j] + " -- ");
            }
            System.out.println();
        }
    }
}