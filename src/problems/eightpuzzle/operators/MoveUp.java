package problems.eightpuzzle.operators;

public class MoveUp extends Movement {

    @Override
    protected int getMovmentPosition(int blankSpacePosition) {
        return blankSpacePosition - 3;
    }
}
