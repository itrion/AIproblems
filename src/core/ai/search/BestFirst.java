package core.ai.search;

import core.ai.Enviroment;
import core.ai.HeuristicFunction;
import core.ai.InformedState;
import core.ai.Search;
import core.ai.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BestFirst extends Search {

    private List<State> openList;
    private HeuristicFunction heuristicFunction;

    public BestFirst(HeuristicFunction heuristicFunction, Enviroment enviroment) {
        super(enviroment);
        this.heuristicFunction = heuristicFunction;
        this.openList = new ArrayList<>();
    }

    @Override
    protected void updateCurrentState() {
        this.setCurrentState(openList.remove(openList.size() - 1));
    }

    @Override
    protected void updateOpenList(List<State> childs) {
        for (Iterator<State> it = childs.iterator(); it.hasNext();) {
            InformedState childState = (InformedState) it.next();
            childState.setEvaluationValue(heuristicFunction.evaluate(childState));
            openList.add(childState);
        }
        Collections.sort(openList);
    }
}
