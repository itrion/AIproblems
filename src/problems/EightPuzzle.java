package problems;

import core.ai.Action;
import core.ai.ActionList;
import core.ai.Enviroment;
import core.ai.Search;
import core.ai.State;
import core.ai.search.BestFirst;
import core.ai.search.BreadthFirst;
import java.util.List;
import problems.eightpuzzle.EightPuzzleState;
import problems.eightpuzzle.EigthPuzzleGoodplacedFunction;
import problems.eightpuzzle.operators.MoveDown;
import problems.eightpuzzle.operators.MoveToTheLeft;
import problems.eightpuzzle.operators.MoveToTheRight;
import problems.eightpuzzle.operators.MoveUp;

public class EightPuzzle implements Enviroment {

    private EightPuzzleState initialState;
    private EightPuzzleState finalState;

    public static void main(String... args) {
        EightPuzzle eightPuzzle = new EightPuzzle();
        eightPuzzle.execute();
    }

    private void execute() {
        this.initialState = new EightPuzzleState(null, getInitialBoard());
        this.finalState = new EightPuzzleState(null, getFinalBoard());
        Search search = new BestFirst(new EigthPuzzleGoodplacedFunction(this), this);
        State finalStateFound = search.searchFinalState();
        while (finalStateFound != null) {
            System.out.println(finalStateFound);
            finalStateFound = finalStateFound.getParent();
        }
    }

    @Override
    public List<Action> getApplicableActions(State state) {
        ActionList applicableList = new ActionList();
        for (Action action : getActionList().getActions())
            if (action.isApplicable(state)) applicableList.add(action);
        return applicableList.getActions();
    }

    @Override
    public State getFinalState() {
        return finalState;
    }

    @Override
    public State getInitialState() {
        return initialState;
    }

    @Override
    public ActionList getActionList() {
        ActionList actions = new ActionList();
        actions.add(new MoveUp());
        actions.add(new MoveDown());
        actions.add(new MoveToTheLeft());
        actions.add(new MoveToTheRight());
        return actions;
    }

    private int[] getInitialBoard() {
        return new int[]{1, 4, 2, 7, 5, 8, 3, 0, 6};
    }

    private int[] getFinalBoard() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    }
}