package core.problems.jars.operators;

import core.ai.Action;
import core.problems.jars.TwoJarsState;

public class EmptyThreeLitersJar extends Action<TwoJarsState> {

    @Override
    public boolean isApplicable(TwoJarsState state) {
        if (state.getWaterInThreeLitersJar() == 0) return false;
        return true;
    }

    @Override
    public TwoJarsState execute(TwoJarsState state) {
        return new TwoJarsState(0, state.getWaterInFourLitersJar(), state);
    }
}
