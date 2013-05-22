package problems;

import core.ai.Action;
import core.ai.ActionList;
import core.ai.Enviroment;
import core.ai.search.MiniMax;
import java.util.ArrayList;
import java.util.List;
import problems.tictactoe.TicTacToeAction;
import problems.tictactoe.TicTacToeHeuristic;
import problems.tictactoe.TicTacToeState;

public class TicTacToe implements Enviroment<TicTacToeState> {

    private TicTacToeState currentState;

    public TicTacToe() {
        this.currentState = getEmptyState();
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.execute();
    }

    private void execute() {
        TicTacToeHeuristic heuristic = new TicTacToeHeuristic();
        MiniMax mimiMax = new MiniMax(heuristic, this);
        double minimaxValue = mimiMax.minimax(currentState, 0, 2);
        System.out.println(minimaxValue);
    }

    @Override
    public List<Action> getApplicableActions(TicTacToeState state) {
        List<Action> applicableActions = new ArrayList<>();
        String[] currentBoard = state.getBoard();
        for (int i=0;i<currentBoard.length;i++)
            if (isEmpty(currentBoard[i])) applicableActions.add(new TicTacToeAction(i, state.getTurnSymbol()));
        return applicableActions;
    }

    @Override
    public TicTacToeState getFinalState() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TicTacToeState getInitialState() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ActionList getActionList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private TicTacToeState getEmptyState() {
        return new TicTacToeState(new String[]{"", "", "", "", "", "", "", "", ""}, "X");
    }

    private boolean isEmpty(String cell) {
        return (cell.equals(""));
    }
}
