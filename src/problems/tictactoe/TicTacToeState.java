package problems.tictactoe;

import core.ai.State;
import core.ai.TurnDependentState;

public class TicTacToeState extends TurnDependentState {

    private String[] board;
    private String turnSymbol;

    public TicTacToeState(String[] board, String turnSymbol) {
        this.board = board;
        this.turnSymbol = turnSymbol;
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
}
