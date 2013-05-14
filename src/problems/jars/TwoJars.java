package problems.jars;

import core.ai.Action;
import core.ai.ActionList;
import core.ai.Enviroment;
import core.ai.Search;
import core.ai.State;
import core.ai.search.noninformed.BreadthFirst;
import problems.jars.operators.EmptyFourLitersJar;
import problems.jars.operators.EmptyThreeLitersJar;
import problems.jars.operators.FillFourLitterJar;
import problems.jars.operators.FillThreeLitterJar;
import problems.jars.operators.TransferFromFourLitersJarToThreeLitersJar;
import problems.jars.operators.TransferFromThreeLitersJarToFourLitersJar;
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
        finalState = new TwoJarsState(3, 2, null);
        currentState = new TwoJarsState(0, 0, null);
        Search search = new BreadthFirst(this);
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
        for (Action applicableAction : getActionList().getActions())
            if (applicableAction.isApplicable(state))
                applicableActions.add(applicableAction);
        return applicableActions;
    }

    @Override
    public ActionList getActionList() {
        ActionList actionList = new ActionList();
        actionList.add(new EmptyFourLitersJar());
        actionList.add(new EmptyThreeLitersJar());
        actionList.add(new FillFourLitterJar());
        actionList.add(new FillThreeLitterJar());
        actionList.add(new TransferFromFourLitersJarToThreeLitersJar());
        actionList.add(new TransferFromThreeLitersJarToFourLitersJar());
        return actionList;
    }
}
