package problems.jars;

import core.ai.InformedState;
import core.ai.State;

public class TwoJarsState extends InformedState {

    private int waterInThreeLitersJar;
    private int waterInFourLitersJar;

    public TwoJarsState(State parent, int waterInThreeLitersJar, int waterInFourLitersJar) {
        super(parent);
        this.waterInThreeLitersJar = waterInThreeLitersJar;
        this.waterInFourLitersJar = waterInFourLitersJar;
    }

    public int getWaterInThreeLitersJar() {
        return waterInThreeLitersJar;
    }

    public int getWaterInFourLitersJar() {
        return waterInFourLitersJar;
    }

    @Override
    public String toString() {
        return "(" + waterInThreeLitersJar + ", " + waterInFourLitersJar + ")";
    }

    @Override
    public boolean equals(State state) {
        TwoJarsState otherState = (TwoJarsState) state;
        return (waterInFourLitersJar == otherState.waterInFourLitersJar && waterInThreeLitersJar == otherState.waterInThreeLitersJar);
    }
}
