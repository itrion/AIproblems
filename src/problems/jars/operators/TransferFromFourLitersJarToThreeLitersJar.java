package problems.jars.operators;

import core.ai.Action;
import problems.jars.TwoJarsState;

public class TransferFromFourLitersJarToThreeLitersJar extends Action<TwoJarsState> {

    @Override
    public boolean isApplicable(TwoJarsState state) {
        if (state.getWaterInFourLitersJar() == 0) return false;
        if (state.getWaterInThreeLitersJar() == 3) return false;
        return true;
    }

    @Override
    public TwoJarsState execute(TwoJarsState state) {
        int waterInFourLitersJar = state.getWaterInFourLitersJar();
        int waterInThreeLitersJar = state.getWaterInThreeLitersJar();
        while (waterInThreeLitersJar < 3 && waterInFourLitersJar > 0) {
            waterInFourLitersJar--;
            waterInThreeLitersJar++;
        }
        return new TwoJarsState(waterInThreeLitersJar, waterInFourLitersJar, state);
    }
}
