package problems.tictactoe;

import core.ai.Action;

public class TicTacToeAction implements Action<TicTacToeState> {

    private int boardIndex;
    private String symbol;

    public TicTacToeAction(int boardIndex, String symbol) {
        this.boardIndex = boardIndex;
        this.symbol = symbol;
    }

    @Override
    public TicTacToeState execute(TicTacToeState state) {
        String[] board = state.getBoard();
        board[boardIndex] = symbol;
        return new TicTacToeState(board, toggleTurnSymbol(symbol));
    }

    @Override
    public boolean isApplicable(TicTacToeState state) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private String toggleTurnSymbol(String symbol) {
        return (symbol.equals("X")) ? "O" : "X";
    }
}
