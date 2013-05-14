package problems.eightpuzzle.operators;

public class MoveToTheLeft extends Movement {

    @Override
    protected int getMovmentPosition(int blankSpacePosition) {
        if (isInLeftColumn(blankSpacePosition)) return -1;
        return blankSpacePosition - 1;
    }

    private boolean isInLeftColumn(int blankSpacePosition) {
        return (blankSpacePosition == 0 || blankSpacePosition == 3 || blankSpacePosition == 6);
    }
}
