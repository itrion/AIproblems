package problems.jars.operators;

import core.ai.Action;
import problems.jars.TwoJarsState;

public class FillThreeLitterJar implements Action<TwoJarsState> {

    @Override
    public boolean isApplicable(TwoJarsState state) {
        if (state.getWaterInThreeLitersJar() == 3) return false;
        return true;
    }

    
    @Override
    public TwoJarsState execute(TwoJarsState state) {
        return new TwoJarsState(state, 3, state.getWaterInFourLitersJar());
    }
}
