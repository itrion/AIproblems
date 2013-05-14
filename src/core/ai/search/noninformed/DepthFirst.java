package core.ai.search.noninformed;

import core.ai.Action;
import core.ai.Enviroment;
import core.ai.Search;
import core.ai.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirst extends Search {

    private Stack<State> stack;
    private List<State> visitedStates;
    private final State finalState;
    private State currentState;

    public DepthFirst(Enviroment enviroment) {
        super(enviroment);
        this.stack = new Stack<>();
        this.visitedStates = new ArrayList<>();
        this.currentState = enviroment.getInitialState();
        this.finalState = enviroment.getFinalState();
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
        List<Action> applicableActions = getEnviroment().getApplicableActions(currentState);
        for (Action applicableAction : applicableActions)
            if (!isVisited(applicableAction.execute(currentState)))
                stack.push(applicableAction.execute(currentState));
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
        currentState = stack.pop();
    }
}
