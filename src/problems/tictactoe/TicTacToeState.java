package problems.tictactoe;

import core.ai.InformedState;
import core.ai.State;


public class TicTacToeState extends InformedState {

    public static final String EMPTY_SYMBOL = "#";
    public static final String X_SYMBOL = "X";
    public static final String O_SYMBOL = "O";
    private String[] board;
    private String turnSymbol;

    public TicTacToeState(String[] board, String nextTurnSymbol) {
        super(null);
        this.board = board;
        this.turnSymbol = nextTurnSymbol;
    }

    @Override
    public boolean equals(State otherState) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String[] getBoard() {
        return board.clone();
    }

    public String getTurnSymbol() {
        return turnSymbol;
    }

    public boolean isFull() {
        for (int i = 0; i < board.length; i++)
            if (board[i].equals(EMPTY_SYMBOL)) return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        builder.append(board[i++]).append(" ").append(board[i++]).append(" ").append(board[i++]).append("\n");
        builder.append(board[i++]).append(" ").append(board[i++]).append(" ").append(board[i++]).append("\n");
        builder.append(board[i++]).append(" ").append(board[i++]).append(" ").append(board[i++]).append("\n");
        return builder.toString();
    }

    int getFreeSpaces() {
        int count=0;
        for (int i = 0; i < board.length; i++)
            if (board[i].equals(EMPTY_SYMBOL)) count++;
        return count;
    }
}
