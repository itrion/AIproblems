package core.ai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Search {

    private List<State> visitedStates;
    private Enviroment enviroment;
    private State currentState;
    private final State finalState;
    private long initTime;
    private long endTime;

    protected Search(Enviroment enviroment) {
        this.enviroment = enviroment;
        this.currentState = enviroment.getInitialState();
        this.finalState = enviroment.getFinalState();
        this.visitedStates = new ArrayList<>();
    }

    protected abstract void updateCurrentState();

    protected abstract void updateOpenList(List<State> childs);

    public Enviroment getEnviroment() {
        return enviroment;
    }

    public State searchFinalState() {
        this.initTime = System.currentTimeMillis();
        while (!currentState.equals(finalState)) {
            updateOpenList(expandStatesFrom(currentState));
            markStateAsVisited(currentState);
            updateCurrentState();
        }
        this.endTime = System.currentTimeMillis();
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    private List<State> expandStatesFrom(State currentState) {
        List<State> childs = new ArrayList<>();
        for (Iterator it = enviroment.getApplicableActions(currentState).iterator(); it.hasNext();) {
            Action applicableAction = (Action) it.next();
            if (!stateIsVisited(getStateChild(applicableAction, currentState)))
                childs.add(getStateChild(applicableAction, currentState));
        }
        return childs;
    }

    private void markStateAsVisited(State currentState) {
        visitedStates.add(currentState);
    }

    private boolean stateIsVisited(State nextState) {
        for (State visitedState : visitedStates)
            if (visitedState.equals(nextState)) return true;
        return false;
    }

    private State getStateChild(Action applicableAction, State currentState) {
        return applicableAction.execute(currentState);
    }

    public State getCurrentState() {
        return currentState;
    }

    public SearchMetrics getSearchMetrics() {
        SearchMetrics searchMetrics = new SearchMetrics();
        searchMetrics.setOpenListSize(getOpenListSize());
        searchMetrics.setMaxOpenListSize(getMaxOpenListSize());
        searchMetrics.setExpandedStates(visitedStates.size());
        searchMetrics.setPathSize(getPathSize(currentState));
        searchMetrics.setSearchTime(endTime - initTime);
        return searchMetrics;
    }

    protected abstract double getOpenListSize();

    protected abstract double getMaxOpenListSize();

    private double getPathSize(State currentState) {
        double sizeCounter = 0;
        State nextState = currentState;
        while ((nextState = nextState.getParent()) != null)
            sizeCounter++;
        return sizeCounter;
    }
}
