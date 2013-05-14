package core.ai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Search {

    private List<State> visitedStates;
    private Enviroment enviroment;
    private State currentState;
    private final State finalState;

    protected Search(Enviroment enviroment) {
        this.enviroment = enviroment;
        this.currentState = enviroment.getInitialState();
        this.finalState = enviroment.getFinalState();
        this.visitedStates = new ArrayList<>();
    }

    public Enviroment getEnviroment() {
        return enviroment;
    }

    public State searchFinalState() {
        while (!currentState.equals(finalState)) {
            updateOpenList(expandStatesFrom(currentState));
            markStateAsVisited(currentState);
            updateCurrentState();
        }
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    private List<State> expandStatesFrom(State currentState) {
        List<State> childs = new ArrayList<>();
        for (Iterator it = enviroment.getApplicableActions(currentState).iterator(); it.hasNext();) {
            Action applicableAction = (Action) it.next();
            if (!stateIsVisited(getCurrentStateChild(applicableAction)))
                childs.add(getCurrentStateChild(applicableAction));
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

    private State getCurrentStateChild(Action applicableAction) {
        return applicableAction.execute(currentState);
    }

    protected abstract void updateCurrentState();

    protected abstract void updateOpenList(List<State> childs);
}
