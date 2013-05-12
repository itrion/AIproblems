package core.ai.search.noninformed;

import core.ai.Action;
import core.ai.Enviroment;
import core.ai.Search;
import core.ai.State;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirst implements Search {

    private Queue<State> queue;
    private List<State> visitedStates;
    private Enviroment enviroment;
    private State finalState;
    private State currentState;

    public BreadthFirst(Enviroment enviroment) {
        this.enviroment = enviroment;
        this.currentState = enviroment.getInitialState();
        this.finalState = enviroment.getFinalState();
        this.queue = new ArrayDeque<>();
        this.visitedStates = new ArrayList<>();
    }

    @Override
    public State searchFinalState() {
        while (true) {
            if (currentState.equals(finalState)) return currentState;
            expandStatesFrom(currentState);
            markStateAsVisited(currentState);
            updateCurrentState();
        }
    }

    private void expandStatesFrom(State currentState) {
        List<Action> applicableActions = enviroment.getApplicableActions(currentState);
        for (Action applicableAction:applicableActions)
            if (!isVisited(applicableAction.execute(currentState))) queue.add(applicableAction.execute(currentState));
    }

    private boolean isVisited(State nextState) {
        for (State visitedState : visitedStates)
            if (visitedState.equals(nextState)) return true;
        return false;
    }

    private void markStateAsVisited(State currentState) {
        visitedStates.add(currentState);
    }

    private void updateCurrentState() {
        currentState = queue.poll();
    }
}
