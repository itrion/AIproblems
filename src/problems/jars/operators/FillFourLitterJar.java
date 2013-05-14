package problems.jars.operators;

import core.ai.Action;
import problems.jars.TwoJarsState;


public class FillFourLitterJar extends Action<TwoJarsState>{

    @Override
    public boolean isApplicable(TwoJarsState state) {
        if (state.getWaterInFourLitersJar()==4) return false;
        return true;
    }

    @Override
    public TwoJarsState execute(TwoJarsState state) {
        return new TwoJarsState(state, state.getWaterInThreeLitersJar(), 4);
    }

}
