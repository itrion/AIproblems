package problems;

import core.ai.Action;
import core.ai.ActionList;
import core.ai.Enviroment;
import core.ai.InformedState;
import core.ai.search.MiniMax;
import java.util.ArrayList;
import java.util.List;
import problems.tictactoe.GameOverChecker;
import problems.tictactoe.TicTacToeAction;
import problems.tictactoe.TicTacToeHeuristic;
import problems.tictactoe.TicTacToeState;

public class TicTacToe implements Enviroment<TicTacToeState> {

    private TicTacToeState currentState;

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.execute();
    }

    private void execute() {
        this.currentState = getInitialState();
        TicTacToeHeuristic heuristic = new TicTacToeHeuristic();
        MiniMax miniMaxForX = new MiniMax(heuristic, this);
        MiniMax miniMaxForO = new MiniMax(heuristic, this);
        System.out.println(currentState);
        int i = 0;
        while (i++ < 10) {
            System.out.println(miniMaxForO.searchNextState((InformedState)currentState, 0, 8));
            currentState = (TicTacToeState) miniMaxForX.getNewState();
            System.out.println(currentState);
            if (gameOver(currentState)) break;
            System.out.println(miniMaxForX.searchNextState((InformedState)currentState, 0, 8));
            currentState = (TicTacToeState) miniMaxForO.getNewState();
            System.out.println(currentState);
            if (gameOver(currentState)) break;
        }
    }

    @Override
    public List<Action> getApplicableActions(TicTacToeState state) {
        List<Action> applicableActions = new ArrayList<>();
        String[] currentBoard = state.getBoard();
        for (int i = 0; i < currentBoard.length; i++)
            if (isEmpty(currentBoard[i]))
                applicableActions.add(new TicTacToeAction(i, state.getTurnSymbol()));
        return applicableActions;
    }

    @Override
    public TicTacToeState getFinalState() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TicTacToeState getInitialState() {
        String[] initialBoard = new String[9];
        for (int i = 0; i < initialBoard.length; i++)
            initialBoard[i] = TicTacToeState.EMPTY_SYMBOL;
        initialBoard[4]=TicTacToeState.X_SYMBOL;
        return new TicTacToeState(initialBoard, TicTacToeState.X_SYMBOL);
    }

    @Override
    public ActionList getActionList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private boolean isEmpty(String cell) {
        return (cell.equals(TicTacToeState.EMPTY_SYMBOL));
    }

    private boolean gameOver(TicTacToeState state) {
        return GameOverChecker.check(state);
    }
}
