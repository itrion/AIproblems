package core.ai.search;

import core.ai.Action;
import core.ai.Enviroment;
import core.ai.Heuristic;
import core.ai.InformedState;
import core.ai.State;
import java.util.ArrayList;
import java.util.List;

public class MiniMax {

    private Heuristic heuristic;
    private Enviroment enviroment;
    private State newState;

    public MiniMax(Heuristic heuristic, Enviroment enviroment) {
        this.heuristic = heuristic;
        this.enviroment = enviroment;
    }

    public State getNewState() {
        return newState;
    }

    public InformedState searchNextState(InformedState state, int depth, int maxDepth) {
        if (depth == maxDepth)
            return evaluateState(state);
        List<InformedState> childs = getChilds(state);
        double miniMaxValue = 0;
        InformedState miniMaxState = null;
        for (InformedState child : childs) {
            miniMaxState = searchNextState(child, depth + 1, maxDepth);
            double childValue = child.getHeuristicValue();
            if (isMaxTurn(depth)) {
                if (childValue > miniMaxValue) {
                    miniMaxValue = childValue;
                    miniMaxState = child;
                }
            } else if (childValue < miniMaxValue) {
                miniMaxValue = childValue;
                miniMaxState = child;
            }
        }
        return miniMaxState;
    }

    private InformedState evaluateState(InformedState state) {
        state.setHeuristicValue(heuristic.evaluate(state));
        return state;
    }

    private List<InformedState> getChilds(InformedState state) {
        List<Action> applicableActions = enviroment.getApplicableActions(state);
        List<InformedState> childs = new ArrayList<>();
        for (Action action : applicableActions)
            childs.add((InformedState) action.execute(state));
        return childs;
    }

    private boolean isMaxTurn(int depth) {
        return (depth % 2 == 0);
    }
}
