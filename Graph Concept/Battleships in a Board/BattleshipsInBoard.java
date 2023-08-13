package graph.problems;

import utils.Reader;
import java.io.IOException;

// Problem link: https://leetcode.com/problems/battleships-in-a-board/description/
class BattleshipsInBoard {
    public static void main (String[] args) throws IOException{
        Reader reader = new Reader();
        int n = reader.nextInt();
        int m = reader.nextInt();

        int[][] board = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                board[i][j] = reader.nextInt();
            }
        }

        char[][] charBoard = new char[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                charBoard[i][j] = (board[i][j] == 1) ? 'X' : '.';
            }
        }

        BattleshipsInBoard obj = new BattleshipsInBoard();
        System.out.println(obj.countBattleships(charBoard));
    }

    public int countBattleships(char[][] board) {
        int battleShips = 0;
        int[][] vis = new int[board.length][board[0].length];

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == 'X' && vis[i][j] == 0) {
                    dfs(i, j, board, board.length, board[0].length, vis);
                    battleShips++;
                }
            }
        }

        return battleShips;
    }

    public void dfs(int i, int j, char[][] board, int n, int m, int[][] vis) {
        if (vis[i][j] == 1) {
            return;
        }
        vis[i][j] = 1;

        // Go Up
        if (i-1 >= 0 && board[i-1][j] == 'X' && vis[i-1][j] == 0) {
            dfs(i-1, j, board, n, m, vis);
        }

        // Go Down
        if (i+1 < n && board[i+1][j] == 'X' && vis[i+1][j] == 0) {
            dfs(i+1, j, board, n, m, vis);
        }

        // Go Left
        if (j-1 >= 0 && board[i][j-1] == 'X' && vis[i][j-1] == 0) {
            dfs(i, j-1, board, n, m, vis);
        }

        // Go Right
        if (j+1 < m && board[i][j+1] == 'X' && vis[i][j+1] == 0) {
            dfs(i, j+1, board, n, m, vis);
        }
    }
}