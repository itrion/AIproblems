package core.problems.jars;

import core.ai.Action;
import core.ai.Enviroment;
import core.ai.Search;
import core.ai.State;
import core.ai.search.noninformed.BreadthFirst;
import java.util.ArrayList;
import java.util.List;

public class TwoJars implements Enviroment {

    private TwoJarsState finalState;
    private TwoJarsState currentState;

    public static void main(String... args) {
        TwoJars twoJars = new TwoJars();
        twoJars.execute();
    }

    private void execute() {
        Search search = new BreadthFirst(this);
        finalState = new TwoJarsState(3, 2, null);
        currentState = new TwoJarsState(0, 0, null);
        State finalStateFound = search.searchFinalState();
        while (finalStateFound != null) {
            System.out.println(finalStateFound);
            finalStateFound = finalStateFound.getParent();
        }
    }
    
    @Override
    public TwoJarsState getFinalState() {
        return finalState;
    }

    @Override
    public TwoJarsState getInitialState() {
        return currentState;
    }

    @Override
    public List<Action> getApplicableActions(State state) {
        List<Action> applicableActions = new ArrayList<>();
        for (Action applicableAction : new OperatorList().getOperators())
            if (applicableAction.isApplicable(state)) applicableActions.add(applicableAction);
        return applicableActions;
    }
}
