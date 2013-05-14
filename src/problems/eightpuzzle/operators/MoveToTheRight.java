package problems.eightpuzzle.operators;

public class MoveToTheRight extends Movement {

    @Override
    protected int getMovmentPosition(int blankSpacePosition) {
        if (isInLeftColumn(blankSpacePosition)) return -1;
        return blankSpacePosition + 1;
    }

    private boolean isInLeftColumn(int blankSpacePosition) {
        return (blankSpacePosition == 2 || blankSpacePosition == 5 || blankSpacePosition == 8);
    }
}
