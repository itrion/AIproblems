package core.problems.jars.operators;

import core.ai.Action;
import core.problems.jars.TwoJarsState;

public class EmptyFourLitersJar extends Action<TwoJarsState> {

    @Override
    public boolean isApplicable(TwoJarsState state) {
        if (state.getWaterInFourLitersJar() == 0) return false;
        return true;
    }

    @Override
    public TwoJarsState execute(TwoJarsState state) {
        return new TwoJarsState(state.getWaterInThreeLitersJar(), 0, state);
    }
}
