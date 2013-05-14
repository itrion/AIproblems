package core.problems.eightpuzzle.operators;

public class MoveDown extends Movement {

    @Override
    protected int getMovmentPosition(int blankSpacePosition) {
        return blankSpacePosition + 3;
    }
}
