import java.util.*;

class Solution {


    public boolean isSafe(int row, int col, char[][] board) {

        // Horizontal: Check left side
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }

        // Upper-left diagonal
        for (int r = row - 1, c = col - 1;
            r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // Lower-left diagonal
        for (int r = row + 1, c = col - 1;
            r < board.length && c >= 0; r++, c--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void saveBoard(char[][] board, List<List<String>> allBoards) {

        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            newBoard.add(new String(board[i]));
        }

        allBoards.add(newBoard);
    }

    public void helper(char[][] board, List<List<String>> allBoards, int col) {

        // Base case
        if (col == board.length) {
            saveBoard(board, allBoards);
            return;
        }

        // Try each row in the current column
        for (int row = 0; row < board.length; row++) {

            if (isSafe(row, col, board)) {

                // Place queen
                board[row][col] = 'Q';

                // Recursive call
                helper(board, allBoards, col + 1);

                // Backtracking
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(board, allBoards, 0);

        return allBoards;
    }


}
