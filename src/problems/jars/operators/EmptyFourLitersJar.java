package problems.jars.operators;

import core.ai.Action;
import problems.jars.TwoJarsState;

public class EmptyFourLitersJar implements Action<TwoJarsState> {

    @Override
    public boolean isApplicable(TwoJarsState state) {
        if (state.getWaterInFourLitersJar() == 0) return false;
        return true;
    }

    @Override
    public TwoJarsState execute(TwoJarsState state) {
        return new TwoJarsState(state, state.getWaterInThreeLitersJar(), 0);
    }
}
