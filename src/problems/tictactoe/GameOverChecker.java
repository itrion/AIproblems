package problems.tictactoe;

public class GameOverChecker {

    public static boolean check(TicTacToeState state) {
        if (state.isFull()) return true;
        String[] board = state.getBoard();
        if (checkFirstRow(board)) return true;
        if (checkSecondRow(board)) return true;
        if (checkThirdRow(board)) return true;
        if (checkFirstColumn(board)) return true;
        if (checkSecondColumn(board)) return true;
        if (checkThirdColumn(board)) return true;
        if (checkFirstDiagonal(board)) return true;
        if (checkSecondDiagonal(board)) return true;
        if (checkFirstRow(board)) return true;
        if (state.getFreeSpaces() < 2) return true;
        return false;
    }

    private static boolean checkFirstRow(String[] board) {
        if (board[0].equals(TicTacToeState.EMPTY_SYMBOL)) return false;
        boolean complete = true;
        for (int i = 0; i < 2; i++)
            complete &= (board[i].equals(board[i + 1]));
        return complete;
    }

    private static boolean checkSecondRow(String[] board) {
        if (board[3].equals(TicTacToeState.EMPTY_SYMBOL)) return false;
        boolean complete = true;
        for (int i = 3; i < 5; i++)
            complete &= (board[i].equals(board[i + 1]));
        return complete;
    }

    private static boolean checkThirdRow(String[] board) {
        if (board[6].equals(TicTacToeState.EMPTY_SYMBOL)) return false;
        boolean complete = true;
        for (int i = 6; i < 8; i++)
            complete &= (board[i].equals(board[i + 1]));
        return complete;
    }

    private static boolean checkFirstColumn(String[] board) {
        if (board[0].equals(TicTacToeState.EMPTY_SYMBOL)) return false;
        boolean complete = true;
        for (int i = 0; i < 6; i += 3)
            complete &= (board[i].equals(board[i + 3]));
        return complete;
    }

    private static boolean checkSecondColumn(String[] board) {
        if (board[1].equals(TicTacToeState.EMPTY_SYMBOL)) return false;
        boolean complete = true;
        for (int i = 1; i < 7; i += 3)
            complete &= (board[i].equals(board[i + 3]));
        return complete;
    }

    private static boolean checkThirdColumn(String[] board) {
        if (board[2].equals(TicTacToeState.EMPTY_SYMBOL)) return false;
        boolean complete = true;
        for (int i = 2; i < 8; i += 3)
            complete &= (board[i].equals(board[i + 3]));
        return complete;
    }

    private static boolean checkFirstDiagonal(String[] board) {
        if (board[0].equals(TicTacToeState.EMPTY_SYMBOL)) return false;
        boolean complete = true;
        for (int i = 0; i < 8; i += 4)
            complete &= (board[i].equals(board[i + 4]));
        return complete;
    }

    private static boolean checkSecondDiagonal(String[] board) {
        if (board[2].equals(TicTacToeState.EMPTY_SYMBOL)) return false;
        boolean complete = true;
        for (int i = 2; i < 6; i += 2)
            complete &= (board[i].equals(board[i + 2]));
        return complete;
    }
}
