package core.ai.search;

import core.ai.Enviroment;
import core.ai.Heuristic;
import core.ai.InformedState;
import core.ai.Search;
import core.ai.State;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BestFirst extends Search {

    private List<State> openList;
    private Heuristic heuristic;
    private double maxOpenListSize;

    public BestFirst(Heuristic heuristicFunction, Enviroment enviroment) {
        super(enviroment);
        this.heuristic = heuristicFunction;
        this.openList = new ArrayList<>();
    }

    @Override
    protected void updateCurrentState() {
        this.setCurrentState(openList.remove(openList.size() - 1));
    }

    @Override
    protected void updateOpenList(List<State> childs) {
        InformedState currentState = (InformedState) getCurrentState();
        if (!currentState.isEvaluated()) heuristic.evaluate(currentState);
        for (Iterator<State> it = childs.iterator(); it.hasNext();) {
            InformedState childState = (InformedState) it.next();
            heuristic.evaluate(childState);
            openList.add(childState);
        }
        if (openList.size() > maxOpenListSize) maxOpenListSize = openList.size();
        openList = heuristic.sort(openList);
    }

    @Override
    protected double getOpenListSize() {
        return openList.size();
    }

    @Override
    protected double getMaxOpenListSize() {
        return maxOpenListSize;
    }
}
