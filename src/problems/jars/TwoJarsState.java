package problems.jars;

import core.ai.State;

public class TwoJarsState implements State {

    private int waterInThreeLitersJar;
    private int waterInFourLitersJar;
    private TwoJarsState parent;

    public TwoJarsState(int waterInThreeLitersJar, int waterInFourLitersJar, TwoJarsState parent) {
        this.waterInThreeLitersJar = waterInThreeLitersJar;
        this.waterInFourLitersJar = waterInFourLitersJar;
        this.parent = parent;
    }

    public int getWaterInThreeLitersJar() {
        return waterInThreeLitersJar;
    }

    public int getWaterInFourLitersJar() {
        return waterInFourLitersJar;
    }

    @Override
    public TwoJarsState getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "(" + waterInThreeLitersJar + ", " + waterInFourLitersJar + ")";
    }

    @Override
    public boolean equals(State otherState) {
        if (otherState instanceof TwoJarsState) {
            TwoJarsState state = (TwoJarsState) otherState;
            return (waterInFourLitersJar == state.waterInFourLitersJar && waterInThreeLitersJar == state.waterInThreeLitersJar);
        }
        return false;
    }
}
