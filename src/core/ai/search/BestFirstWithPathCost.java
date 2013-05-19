package core.ai.search;

import core.ai.Enviroment;
import core.ai.Heuristic;
import core.ai.InformedState;
import core.ai.State;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BestFirstWithPathCost extends BestFirst {

    public BestFirstWithPathCost(Heuristic heuristicFunction, Enviroment enviroment) {
        super(heuristicFunction, enviroment);
    }

    @Override
    protected void updateOpenList(List<State> childs) {
        Heuristic heuristic = getHeuristic();
        List<State> openList = getOpenList();
        InformedState currentState = (InformedState) getCurrentState();
        if (!currentState.isEvaluated()) evaluateCurrentState(currentState);
        if (!currentState.isCostCalculated()) calculateCurrentStateCost(currentState);
        for (Iterator<State> it = childs.iterator(); it.hasNext();) {
            InformedState childState = (InformedState) it.next();
            childState.setHeuristicValue(heuristic.evaluate(childState));
            childState.setCostValue(getCostValueOf(childState));
            openList.add(childState);
        }
        if (openList.size() > getMaxOpenListSize()) setMaxOpenListSize(openList.size());
        Collections.sort(openList, this);
    }

    private double getCostValueOf(InformedState state) {
        if (state == null)
            return 0;
        if (state.isCostCalculated())
            return state.getCostValue();
        else
            return getCostValueOf((InformedState) state.getParent()) + 1;

    }

    private void calculateCurrentStateCost(InformedState currentState) {
        currentState.setCostValue(getCostValueOf(currentState));
    }

    @Override
    public int compare(State stateA, State stateB) {
        return compare((InformedState) stateA, (InformedState) stateB);
    }

    @Override
    public int compare(InformedState stateA, InformedState stateB) {
        double heuristicValueA = stateA.getHeuristicValue();
        double heuristicValueB = stateB.getHeuristicValue();
        if (heuristicValueA < heuristicValueB) return 1;
        if (heuristicValueA == heuristicValueB)
            if (stateA.getCostValue() < stateB.getCostValue())
                return 1;
        return -1;
    }
}
