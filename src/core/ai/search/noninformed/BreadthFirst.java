package core.ai.search.noninformed;

import core.ai.Action;
import core.ai.Enviroment;
import core.ai.Search;
import core.ai.State;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirst<Type extends State> implements Search {

    private Queue<Type> queue;
    private List<Type> visitedStates;
    private Enviroment<Type> enviroment;

    public BreadthFirst(Enviroment enviroment) {
        this.enviroment = enviroment;
        this.queue = new ArrayDeque<>();
        this.visitedStates = new ArrayList<>();
    }

    @Override
    public Type searchFinalState() {
        Type finalState = enviroment.getFinalState();
        Type currentState = enviroment.getInitialState();
        while (true) {
            if (currentState.equals(finalState)) return currentState;
            expandStatesFrom(currentState);
            visitedStates.add(currentState);
            currentState = queue.poll();
        }
    }

    private void expandStatesFrom(Type currentState) {
        List<Action<Type>> applicableActions = enviroment.getApplicableActions(currentState);
        for (Action<Type> applicableAction:applicableActions)
            if (!isVisited(applicableAction.execute(currentState))) queue.add(applicableAction.execute(currentState));
    }

    private boolean isVisited(Type nextState) {
        for (Type visitedState : visitedStates)
            if (visitedState.equals(nextState)) return true;
        return false;
    }
}
