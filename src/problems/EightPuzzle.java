package problems;

import core.ai.Action;
import core.ai.ActionList;
import core.ai.Enviroment;
import core.ai.SearchMetrics;
import core.ai.State;
import core.ai.searches.BestFirst;
import core.ai.searches.BestFirstWithPathCost;
import java.util.List;
import problems.eightpuzzle.EightPuzzleMissplacedHeuristic;
import problems.eightpuzzle.EightPuzzleState;
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

        BestFirstWithPathCost bestFirstWithPathCost = new BestFirstWithPathCost(new EightPuzzleMissplacedHeuristic(this), this);
        bestFirstWithPathCost.searchFinalState();
        System.out.println("Best First With Path Cost");
        printMetrics(bestFirstWithPathCost.getSearchMetrics());

        BestFirst bestFirst = new BestFirst(new EightPuzzleMissplacedHeuristic(this), this);
        bestFirst.searchFinalState();
        System.out.println("Best First");
        printMetrics(bestFirst.getSearchMetrics());
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
        //return new int[]{1, 0, 2, 3, 4, 5, 6, 7, 8}; //one Move
        //return new int[]{1, 4, 2, 3, 0, 5, 6, 7, 8}; //two Move
        //return new int[]{1, 4, 2, 3, 7, 5, 6, 0, 8}; //three Move
        return new int[]{0, 8, 7, 6, 5, 4, 3, 2, 1}; // extreme
    }

    private int[] getFinalBoard() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    }

    private void printMetrics(SearchMetrics metrics) {
        System.out.println("pathSize: " + metrics.getPathSize());
        System.out.println("statesExpanded: " + metrics.getStatesExpanded());
        System.out.println("openListSize: " + metrics.getOpenListSize());
        System.out.println("maxOpenListSize: " + metrics.getMaxOpenListSize());
        System.out.println("searchTime: " + metrics.getSearchTime() + "\n\n");
    }
}
