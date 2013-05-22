package problems.tictactoe;

import core.ai.MiniMaxState;
import core.ai.State;

public class TicTacToeState extends MiniMaxState {

    private String[] state;

    public TicTacToeState(String[] state, boolean maxState, State parent) {
        super(maxState, parent);
        this.state = state;
    }

    public void putSymbol(String symbol, int index) {
        state[index] = symbol;
    }

    public String[] getState() {
        return state;
    }

    @Override
    public boolean equals(State otherState) {
        TicTacToeState other = (TicTacToeState) otherState;
        for (int i = 0; i < state.length; i++)
            if (!state[i].equals(other.state[i])) return false;
        return true;
    }
}
