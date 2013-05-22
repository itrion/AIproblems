package problems.jars.operators;

import core.ai.Action;
import problems.jars.TwoJarsState;

public class TransferFromThreeLitersJarToFourLitersJar implements Action<TwoJarsState> {

    @Override
    public boolean isApplicable(TwoJarsState state) {
        if (state.getWaterInThreeLitersJar() == 0) return false;
        if (state.getWaterInFourLitersJar() == 4) return false;
        return true;
    }

    @Override
    public TwoJarsState execute(TwoJarsState state) {
        int waterInFourLitersJar = state.getWaterInFourLitersJar();
        int waterInThreeLitersJar = state.getWaterInThreeLitersJar();
        while (waterInFourLitersJar < 4 && waterInThreeLitersJar > 0) {
            waterInThreeLitersJar--;
            waterInFourLitersJar++;
        }
        return new TwoJarsState(state, waterInThreeLitersJar, waterInFourLitersJar);
    }
}
