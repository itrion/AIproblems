package problems.eightpuzzle.operators;

import core.ai.Action;
import core.ai.State;
import problems.eightpuzzle.EightPuzzleState;

public abstract class Movement extends Action<EightPuzzleState> {

    @Override
    public EightPuzzleState execute(EightPuzzleState state) {
        int blankSpacePosition = getBlankSpacePosition(state);
        int upPosition = getMovmentPosition(blankSpacePosition);
        return moveBlankSpace(state, blankSpacePosition, upPosition);
    }

    @Override
    public boolean isApplicable(EightPuzzleState state) {
        int movmentPosition = getMovmentPosition(getBlankSpacePosition(state));
        return (movmentPosition >= 0 && movmentPosition <= 8);
    }

    private int getBlankSpacePosition(EightPuzzleState state) {
        int[] board = state.getBoard();
        for (int i = 0; i < board.length; i++)
            if (board[i] == 0) return i;
        throw new MoveUp.BadStateException();
    }

    protected abstract int getMovmentPosition(int blankSpacePosition);

    protected EightPuzzleState moveBlankSpace(EightPuzzleState state, int blankSpacePosition, int targetPosition) {
        int[] board = state.getBoard().clone();
        int aux = board[targetPosition];
        board[targetPosition] = board[blankSpacePosition];
        board[blankSpacePosition] = aux;
        return new EightPuzzleState((State) state, board);
    }

    public static class BadStateException extends RuntimeException {

        public BadStateException() {
        }
    }
}
