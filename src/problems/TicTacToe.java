package problems;

import core.ai.Action;
import core.ai.ActionList;
import core.ai.InformedState;
import core.ai.PlayersEnviroment;
import core.ai.search.MiniMax;
import java.util.ArrayList;
import java.util.List;
import problems.tictactoe.GameOverChecker;
import problems.tictactoe.TicTacToeAction;
import problems.tictactoe.TicTacToeHeuristic;
import problems.tictactoe.TicTacToeState;

public class TicTacToe implements PlayersEnviroment<TicTacToeState> {

    private TicTacToeState currentState;

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.execute();
    }
    private String turnSymbol;

    private void execute() {
        this.currentState = getInitialState();
        TicTacToeHeuristic heuristic = new TicTacToeHeuristic();
        MiniMax miniMax = new MiniMax(heuristic, this);
        int i = 0;
        System.out.println(currentState);
        while (i++ < 10) {
            turnSymbol = TicTacToeState.X_SYMBOL;
                currentState = (TicTacToeState) miniMax.searchNextState((InformedState) currentState, 1);
            System.out.println(currentState);
            if (gameOver(currentState)) break;
            turnSymbol = TicTacToeState.O_SYMBOL;
            currentState = (TicTacToeState) miniMax.searchNextState((InformedState) currentState, 100);
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

    @Override
    public boolean isFinalState(TicTacToeState state) {
        return gameOver(state);
    }

    @Override
    public boolean isIsTurnOf(TicTacToeState state) {
        return (turnSymbol.equals(state.getTurnSymbol()));
    }
}
