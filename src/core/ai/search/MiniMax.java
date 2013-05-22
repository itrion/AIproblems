package core.ai.search;

import core.ai.Action;
import core.ai.MiniMaxState;
import core.ai.PlayerDependentHeuristic;
import core.ai.TwoAgentsEnviroment;
import java.util.List;

public class MiniMax {

    private PlayerDependentHeuristic heuristic;
    private TwoAgentsEnviroment enviroment;

    public MiniMax(PlayerDependentHeuristic heuristic, TwoAgentsEnviroment enviroment) {
        this.heuristic = heuristic;
        this.enviroment = enviroment;
    }

    public double minimax(MiniMaxState state, int currentDepth, int maxDepth) {
        double vp = 0;
        if (currentDepth == maxDepth)
            return heuristic.evaluate(state, enviroment.isAgentATurn());
        List<Action> applicableActions = enviroment.getApplicableActions(state);
        for (int i = 0; i < applicableActions.size(); i++) {
            MiniMaxState childState = (MiniMaxState) applicableActions.get(i).execute(state);
            childState.setMaxState(!state.isMaxState());
            double childValue = minimax(childState, currentDepth++, maxDepth);
            if (i == 1) vp = childValue;
            else if (state.isMaxState()) vp = Math.max(vp, childValue);
            else vp = Math.max(vp, childValue);
        }
        return vp;
    }
}
