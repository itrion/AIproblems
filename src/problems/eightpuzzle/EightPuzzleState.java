package problems.eightpuzzle;

import core.ai.InformedState;
import core.ai.State;

public class EightPuzzleState extends InformedState {

    private int[] board;

    public EightPuzzleState(State parent, int[] board) {
        super(parent);
        this.board = board;
    }

    @Override
    public boolean equals(State state) {
        EightPuzzleState otherState = (EightPuzzleState) state;
        boolean areEquals = true;
        for (int i = 0; i < board.length; i++)
            areEquals &= (board[i] == otherState.board[i]);
        return areEquals;
    }

    public int[] getBoard() {
        return board.clone();
    }

    @Override
    public String toString() {
        String out="";
        out += board[0] + " " + board[1] + " " + board[2] + "\n";
        out += board[3] + " " + board[4] + " " + board[5] + "\n";
        out += board[6] + " " + board[7] + " " + board[8] + "\n";
        return out;
    }
}
