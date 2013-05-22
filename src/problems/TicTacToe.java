package problems;

import core.ai.Action;
import core.ai.ActionList;
import core.ai.Agent;
import core.ai.State;
import core.ai.TwoAgentsEnviroment;
import core.ai.search.MiniMax;
import java.util.List;
import problems.tictactoe.TicTacToeEvaluationFunction;
import problems.tictactoe.TicTacToeState;


public class TicTacToe implements TwoAgentsEnviroment {
    private Agent agentA;
    private Agent agentB;
    
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.execute();
    }

    private void execute() {
        TicTacToeState state = getEmptyState();
        MiniMax miniMax = new MiniMax(new TicTacToeEvaluationFunction(), this);
        double minimaxValue = miniMax.minimax(state, 0, 10);
        System.out.println(String.valueOf(minimaxValue));
    }

    private TicTacToeState getEmptyState() {
        return new TicTacToeState(new String[9], false, null);
    }

    @Override
    public List<Action> getApplicableActions(State state) {
        throw new UnsupportedOperationException("Not supported yet.");
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

    @Override
    public Agent getAgentA() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Agent getAgentB() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isAgentATurn() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isAgentBTurn() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
