package problems.eightpuzzle;

import core.ai.State;

public class EightPuzzleState implements State {

    private EightPuzzleState parent;
    private int[] board;

    public EightPuzzleState(EightPuzzleState parent, int[] board) {
        this.parent = parent;
        this.board = board;
    }

    @Override
    public State getParent() {
        return parent;
    }

    @Override
    public boolean equals(State otherState) {
        EightPuzzleState other = (EightPuzzleState) otherState;
        return (board == other.board);
    }

    public int[] getBoard() {
        return board.clone();
    }
}
