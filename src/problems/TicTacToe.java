package problems;

import core.ai.Action;
import core.ai.ActionList;
import core.ai.InformedState;
import core.ai.PlayersEnviroment;
import core.ai.searches.MiniMax;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.JOptionPane;
import problems.tictactoe.GameOverChecker;
import problems.tictactoe.StateViewer;
import problems.tictactoe.TicTacToeAction;
import problems.tictactoe.TicTacToeHeuristic;
import problems.tictactoe.TicTacToeState;

public class TicTacToe extends Observable implements PlayersEnviroment<TicTacToeState> {

    private String turnSymbol;
    private TicTacToeState currentState;
    private final StateViewer stateViewer;

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.execute();
    }

    public TicTacToe() {
        this.currentState = getInitialState();
        stateViewer = new StateViewer(currentState);
        addObserver(stateViewer);
    }

    @Override
    public TicTacToeState getInitialState() {
        String[] initialBoard = new String[9];
        for (int i = 0; i < initialBoard.length; i++)
            initialBoard[i] = TicTacToeState.EMPTY_SYMBOL;
        return new TicTacToeState(initialBoard, TicTacToeState.X_SYMBOL);
    }

    private void execute() {
        TicTacToeHeuristic heuristic = new TicTacToeHeuristic();
        MiniMax miniMax = new MiniMax(heuristic, this);
        play(miniMax);
    }

    private void play(MiniMax miniMax) {
        turnSymbol = TicTacToeState.X_SYMBOL;
        while (true) {
            waitNextOrder();
            updateCurrentState(miniMax, 1);
            toggelTurn();
            if (isFinalState(currentState)) break;
            waitNextOrder();
            updateCurrentState(miniMax, 5);
            toggelTurn();
            if (isFinalState(currentState)) break;
        }
        waitNextOrder();
        stateViewer.setVisible(false);
        stateViewer.dispose();
        System.exit(0);
    }

    private void updateCurrentState(MiniMax miniMax, int maxDepth) {
        currentState = playTurn(miniMax, maxDepth);
        setChanged();
        notifyObservers(currentState);
    }

    private void toggelTurn() {
        turnSymbol = (isXTurn()) ? TicTacToeState.O_SYMBOL : TicTacToeState.X_SYMBOL;
    }

    private TicTacToeState playTurn(MiniMax miniMax, int maxDepth) {
        return (TicTacToeState) miniMax.searchNextState((InformedState) currentState, maxDepth);
    }

    @Override
    public boolean isFinalState(TicTacToeState state) {
        return GameOverChecker.check(state);
    }

    private boolean isXTurn() {
        return turnSymbol.equals(TicTacToeState.X_SYMBOL);
    }

    @Override
    public List<Action> getApplicableActions(TicTacToeState state) {
        return getApplicableActions(new ArrayList<Action>(), state.getBoard(), state.getTurnSymbol());
    }

    private List<Action> getApplicableActions(List<Action> applicableActions, String[] currentBoard, String turnSymbol) {
        for (int i = 0; i < currentBoard.length; i++)
            if (isEmptyCell(currentBoard[i]))
                applicableActions.add(new TicTacToeAction(i, turnSymbol));
        return applicableActions;
    }

    private boolean isEmptyCell(String cell) {
        return (cell.equals(TicTacToeState.EMPTY_SYMBOL));
    }

    @Override
    public boolean isTurnOf(TicTacToeState state) {
        return (turnSymbol.equals(state.getTurnSymbol()));
    }

    @Override
    public ActionList getActionList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public TicTacToeState getFinalState() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void waitNextOrder() {
        JOptionPane.showMessageDialog(null, "clic to next step", "Hi", JOptionPane.PLAIN_MESSAGE);
    }
}
